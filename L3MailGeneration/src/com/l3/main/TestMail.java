package com.l3.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import java.util.Date;

import java.util.GregorianCalendar;

import java.util.Iterator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.pff.PSTException;

import com.pff.PSTFile;

import com.pff.PSTFolder;

import com.pff.PSTMessage;

public class TestMail {


	//final String filepath = "F://Documents and Settings//bgh31926//Local Settings//Application Data//Microsoft//Outlook//archive.pst";
	final String filepath = "D://MailBox//Local MailBox.pst";
	final String INITCOM = "Initial Comment:";
	final String SUBHEADERFROM = "[umts-npo-sst-Customer support][";
	final String SUBHEADERFROMRD = "[umts-npo-sst-R&D support][";
	// "D:/Backup/Outlook/Mail_4_5_10.pst";
	final boolean getReportForToday = false;
	// D:/mail/outlook/exchange-mail.pst
	ArrayList<String> isssueIds = new ArrayList<String>();
	HashMap<String, String> existingIssues = new HashMap<String, String>();

	HashMap<String, String> issueLatestDateMap = new HashMap<String, String>();

	//HashMap<String, String> ARData = new HashMap<String, String>();
	ArrayList<String> ArHeaderData = new ArrayList<String>(Arrays.asList(
			"artifact_id", "Priority", "Submitted By", "Assigned to",
			"open_date", "last_modified_date", "Summary", "Hardware",
			"Technologies", "Team", "Install Type", "NPO Release", "Severity",
			"Domain", "AR/FR/CR number", "Server Hostname/IP address",
			"NPO Version", "Customer Name/Location", "Isabelle Comments",
			"Status", "Who", "Ari Contact", "Ari Comments", "From"));
	Date startDate = null; 

	Date endDate = null;

	int counter = 0;

	final String writeFilePath = "D://views//L3Report//L3Report.csv";
	PrintWriter PrintWr = null;
//	final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm");
	SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");

	private Map<String, Map<String, String>> trackers;
	public TestMail() {
		this.trackers = new HashMap<>();
		ProcessLastWeekTrackerSheet();
		processDate();
		try {
			FileWriter fileWr = new FileWriter(new File(writeFilePath));
			PrintWr = new PrintWriter(fileWr);
			addHeader();
			processPST();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			PrintWr.close();
		}

	}

	private void addHeader() {

		for (String header : ArHeaderData) {
			PrintWr.append(header);
			PrintWr.append(",");
		}
		PrintWr.append("\n");
	}

	public static void main(String args[]) {
		new TestMail().processPST();

		//new TestMail();		

	}

	private void processDate() {
		GregorianCalendar gc = null;
		gc = new GregorianCalendar(2015, Calendar.FEBRUARY, 16, 10, 00);
		this.startDate = gc.getTime();
		gc = new GregorianCalendar(2015, Calendar.FEBRUARY, 17, 12, 34);
		this.endDate = gc.getTime();
	}

	/**
	 * 
	 * Processes a pst File
	 */

	public void processPST() {

		try {			

			PSTFile pstFile = new PSTFile(filepath);
			System.out.println("PST Name "
					+ pstFile.getMessageStore().getDisplayName());
			processFolder(pstFile.getRootFolder());
			UpdateMailDataToCSV();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 
	 * Processes a Folder and Emails inside it
	 * 
	 * @param folder
	 * 
	 * @throws IOException
	 * 
	 * @throws PSTException
	 */

	private void processFolder(PSTFolder folder) throws IOException,
	PSTException {

		processFolderEmail(folder);

		if (folder.hasSubfolders()) {

			Iterator<PSTFolder> itr = folder.getSubFolders().iterator();

			while (itr.hasNext()) {

				processFolder((PSTFolder) itr.next());

			}

		}

		System.out.println("Exit process Folder");

	}

	/*
	 * 
	 * Method to process email folder
	 */

	private void processFolderEmail(PSTFolder folder) throws IOException,
	PSTException {

		if (folder.getDisplayName().startsWith("L3_Support")) {

			System.out.println(" Folder Name: " + folder.getDisplayName()
					+ " Content: " + folder.getContentCount());
			int mailCount = folder.getContentCount();

			int startIndex = 0;

			if (mailCount > 0) {
				iterateMailList(folder, startIndex, mailCount);
			}
		
			System.out.println("Exit Folder bgh_muse_l3");
		}
		

	}

	/**

	 * 

	 * 

	 */

	private void iterateMailList(PSTFolder folder, int startIndex, int mailCount)
			throws IOException, PSTException {
		System.out.println("MailCount : "+mailCount);
		if (folder.getContentCount() > 0) {
			PSTMessage email = (PSTMessage) folder.getNextChild();
			while (email != null) {
				processEmail(email);
				email = (PSTMessage) folder.getNextChild();
			}

		}
	}

	private void createMapWithLatestDate(PSTMessage email) {
		Date rcvDate = email.getMessageDeliveryTime();

		String to = email.getDisplayTo();

		String cc = email.getDisplayCC();

		String from = email.getSenderName();

		String subject = email.getSubject();

		if (to.compareToIgnoreCase("bgh_muse_l3") != -1
				|| cc.compareToIgnoreCase("l3") != -1) {
			if (rcvDate.compareTo(startDate) >= 0
					&& rcvDate.compareTo(endDate) <= 0) {

				System.out.println("From is : " + from);
				if (from
						.equalsIgnoreCase("umts-npo-sst-customersupport@forge.alcatel-lucent.com")) {

					int index = subject.indexOf(SUBHEADERFROM)
							+ SUBHEADERFROM.length();

					int nextIndex = subject.indexOf(']', index);

					String Id = subject.substring(index, nextIndex).trim();
					issueLatestDateMap.put(Id, rcvDate.toString());
				} else if (from
						.equalsIgnoreCase("umts-npo-sst-rampdsupport@acos.alcatel-lucent.com")
						|| from
						.equalsIgnoreCase("umts-npo-sst-rampdsupport@forge.alcatel-lucent.com")) {

					int index = subject.indexOf(SUBHEADERFROMRD)
							+ SUBHEADERFROMRD.length();

					int nextIndex = subject.indexOf(']', index);

					String Id = subject.substring(index, nextIndex).trim();
					issueLatestDateMap.put(Id, rcvDate.toString());
				}
			}
		}

	}

	/**
	 * 
	 * Method to process email
	 * 
	 * @param email
	 */

	private void processEmail(PSTMessage email) {

		TrackerData trackerData = new TrackerData();
		
		HashMap<String, String> ARData = new HashMap<String, String>();
		//Date d = email.getMessageDeliveryTime();
		
		String date = sdf.format(email.getMessageDeliveryTime());
		Date rcvDate = null;
		try {
			rcvDate = sdf.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(rcvDate.toString().equalsIgnoreCase("Mon Feb 16 12:04:18 IST 2015")){
		System.out.println("Received Date  " + rcvDate.toString());
		}
		String to = email.getDisplayTo();
		String cc = email.getDisplayCC();
		String from = email.getSenderName();
		String subject = email.getSubject();
		if (to.compareToIgnoreCase("bgh_muse_l3") != -1
				|| cc.compareToIgnoreCase("l3") != -1) {
			Calendar now = Calendar.getInstance();
			Date today = now.getTime();

			if (rcvDate.compareTo(today) != 0 && getReportForToday) {
				return;
			}
			// if(rcvDate.compareTo(today)==0) {
			if (subject.contains("42938")) {
				System.out.println("");
			}
			
			if (rcvDate.compareTo(startDate) >= 0
					&& rcvDate.compareTo(endDate) <= 0) {
				if (from
						.equalsIgnoreCase("umts-npo-sst-customersupport@forge.alcatel-lucent.com")
						|| from
						.equalsIgnoreCase("umts-npo-sst-rampdsupport@acos.alcatel-lucent.com")
						|| from
						.equalsIgnoreCase("umts-npo-sst-rampdsupport@forge.alcatel-lucent.com")) {
					String Id = "";

					if (from
							.equalsIgnoreCase("umts-npo-sst-customersupport@forge.alcatel-lucent.com")) {
						int index = subject.indexOf(SUBHEADERFROM)
								+ SUBHEADERFROM.length();
						// System.out.println("index is : "+index);

						int nextIndex = subject.indexOf(']', index);
						System.out.println("nextIndex : " + nextIndex);
						Id = subject.substring(index, nextIndex).trim();

						System.out.println("Tracker ID:" + Id);
						if(Id.equalsIgnoreCase("#116380")){
							System.out.println("Tracker ID:" + Id);
						//	System.out.println("Received Date  " + rcvDate);
						}
					} else if (from
							.equalsIgnoreCase("umts-npo-sst-rampdsupport@acos.alcatel-lucent.com")
							|| from
							.equalsIgnoreCase("umts-npo-sst-rampdsupport@forge.alcatel-lucent.com")) {
						int index = subject.indexOf(SUBHEADERFROMRD)
								+ SUBHEADERFROMRD.length();
						System.out.println("index is : " + index);

						int nextIndex = subject.indexOf(']', index);
						System.out.println("nextIndex : " + nextIndex);
						Id = subject.substring(index, nextIndex).trim();

						System.out.println("Tracker ID:" + Id);
						if(Id.equalsIgnoreCase("#116380")){
							System.out.println("Tracker ID:" + Id);
							//System.out.println("Received Date  " + rcvDate);
						}
					}

					/*
					 * String latestDate = issueLatestDateMap.get(Id);
					 * if(!latestDate.equalsIgnoreCase(rcvDate.toString())){
					 * return; }
					 */// if(isssueIds.contains(Id)){
					// return;
					// }
					Id = Id.toString().replace('#', ' ').trim();
					System.out.println("Tracker ID after modification:" + Id);
					if (Id.contains("42938")) {
						System.out.println("");
					}

					String From = from
							.equalsIgnoreCase("umts-npo-sst-customersupport@forge.alcatel-lucent.com") ? "Customer"
									: "R&D";

					ARData.put("From", From.trim());
					trackerData.setFrom(From.trim());
					
					isssueIds.add(Id);

					ARData.put("artifact_id", Id);
					trackerData.setArtifact_id(Id);

					String body1 = email.getBody();

					String update = body1.substring(body1.indexOf("support"),
							body1.indexOf("You can respond"));
					String updatedBy = update
							.substring(update.indexOf("by") + 2);
					String body = body1.substring(body1.indexOf("Status:"),
							body1.indexOf("Initial Comment:")).trim();

					ARData.put("Who", updatedBy.trim());
					trackerData.setWho(updatedBy.trim());
					
					ARData.put("last_modified_date", rcvDate.toString());
					trackerData.setLast_modified_date(rcvDate);
					
					char bodyArr[] = body.toCharArray();
					int i = 0;
					StringBuffer strBuf = new StringBuffer();
					String key = null;
					String value = null;
					while (i != bodyArr.length) {
						char ch = bodyArr[i];
						if (ch == ':') {
							String str = strBuf.toString().replace('>', ' ')
									.trim();
							if (!ArHeaderData.contains(str)) {
//								System.out.println("NOT Key: " + str);
//								System.out.println("Key1: " + key);

							}
							key = str;
						//	System.out.println("Key: " + key);
							strBuf = new StringBuffer();
						} else if (ch == '\n') {
							value = strBuf.toString();
						//	System.out.println("Value: " + value);
							if (value != null && !value.equals("")) {
								strBuf = new StringBuffer();
								ARData.put(key.trim(), value.trim());
//								populateTrackerData(trackerData, key.trim(),value.trim());
							}
							key = null;
							value = null;
						} else if (ch != '\r') {
							strBuf.append(bodyArr[i]);
						}
						i++;
					}
					if (value != null){
						ARData.put(key.trim(), value.trim());
//						populateTrackerData(trackerData, key.trim(),value.trim());
					}
				//	UpdateMailDataToCSV();
					if(trackers.get(trackerData.getArtifact_id())!= null){
						Map<String, String> data = trackers.get(trackerData.getArtifact_id());
						System.out.println("trackers "+ trackers);
						System.out.println("Hello "+ data);
						System.out.println("rcvDate : "+rcvDate);
						Date d = null;
						try {
							d = sdf.parse(data.get("last_modified_date").toString());
						} catch (ParseException e) {
							System.out.println(data.get("last_modified_date"));
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(rcvDate.compareTo(d)  > 0 || rcvDate.compareTo(d)==0){
			        		System.out.println("Date1 is after Date2");
			        		trackers.put(trackerData.getArtifact_id(), ARData);
			        	}
					}else{
						trackers.put(trackerData.getArtifact_id(), ARData);
					}
				}
				
			}
		
		}
		
		

	}
	private void UpdateMailDataToCSV() {

		for(Map<String, String> ARData :trackers.values()){
			for (String headerName : ArHeaderData) {
				String value = ARData.get(headerName);
				if (value != null)
					value = value.replace(',', ' ');

				if ("Ari Contact".equalsIgnoreCase(headerName)) {
					String id = ARData.get("artifact_id").toString();
					String assignee = existingIssues.containsKey(id) ? existingIssues
							.get(id)
							: "New";
							PrintWr.append(assignee.trim());
				} else if (value != null) {
					PrintWr.append(value);
				}/*
				 * else { PrintWr.append(','); }
				 */
				PrintWr.append(',');
			}
			PrintWr.append("\n");
		}
	}

	private void ProcessLastWeekTrackerSheet() {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(
					"D://views//L3Report//Tracker_report_Aricent.xls"));
			Sheet sheet = workbook.getSheet(1);
			for (int i = 1; i < sheet.getRows(); i++) {
				Cell a1 = sheet.getCell(0, i);
				Cell b2 = sheet.getCell(21, i);
				String id = a1.getContents();
				String assigne = b2.getContents();
				existingIssues.put(id, assigne);
			}

			sheet = workbook.getSheet(2);
			for (int i = 1; i < sheet.getRows(); i++) {
				Cell a1 = sheet.getCell(0, i);
				Cell b2 = sheet.getCell(21, i);
				String id = a1.getContents();
				String assigne = b2.getContents();
				existingIssues.put(id, assigne);
			}

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Finished - close the workbook and free up memory
			workbook.close();
		}
	}
}
