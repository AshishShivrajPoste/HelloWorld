import java.util.*;

import jxl.Sheet;
import jxl.Cell;
import jxl.Workbook;
import java.io.*;

public class SprintBackLog extends XLFile {

	String Location = "TA_S<id>/SPB_TA_S<id>.xls";

	SprintBackLog(String sID) {
		Location = Location.replace("<id>", sID);
		setFileName(Location);
	}

	@Override
	public List<TaskInfo> readFile()  {

		List<TaskInfo> loTaskInfoList = new ArrayList<TaskInfo>();
		try {
			File f = new File(getFileName());
			Workbook loWorkbook = Workbook.getWorkbook(f);
			Sheet backLog = loWorkbook.getSheet(0);
			boolean typeFlag = false;
			Cell[] cellArrayDup = null;
			String cri = " ";
			
			 Map<String,UTandReview> loUTandReviewMap = new HashMap<String,UTandReview>();
	           UTandReview loUTandReview = null;
				backLog = loWorkbook.getSheet(3);
				int count = 1;
				
				for (int i = 8; i < backLog.getRows();i++) {
					cellArrayDup = backLog.getRow(i);
					if(cellArrayDup[2].getContents() == null || cellArrayDup[2].getContents().length() == 0){
						loUTandReview = new UTandReview();
						loUTandReview.setUTCount(Integer.toString(count));
						loUTandReviewMap.put(cri, loUTandReview);
						break;
						}
					if(cri.equals(cellArrayDup[2].getContents()))
						count++;
					else
					{
						loUTandReview = new UTandReview();
						loUTandReview.setUTCount(Integer.toString(count));
						loUTandReviewMap.put(cri, loUTandReview);
						count =1;
					    cri = cellArrayDup[2].getContents();
					}
				}
				
				backLog = loWorkbook.getSheet(4);
				count = 1;
				cri = "";
				for (int i = 31; i < backLog.getRows();i++) {
					cellArrayDup = backLog.getRow(i);
					if(cellArrayDup[2].getContents() == null || cellArrayDup[2].getContents().length() == 0){
						loUTandReview = loUTandReviewMap.get(cri);
						if(loUTandReview != null)
							loUTandReview.setReviewCount(Integer.toString(count));
							else{
								loUTandReview = new UTandReview();
								loUTandReview.setReviewCount(Integer.toString(count));
							}
						loUTandReviewMap.put(cri, loUTandReview);
						break;}
					if(cri.equals(cellArrayDup[2].getContents()))
						count++;
					else
					{
						loUTandReview = loUTandReviewMap.get(cri);
						if(loUTandReview != null)
						loUTandReview.setReviewCount(Integer.toString(count));
						else{
							loUTandReview = new UTandReview();
							loUTandReview.setReviewCount(Integer.toString(count));
						}
						loUTandReviewMap.put(cri, loUTandReview);
						count =1;
					    cri = cellArrayDup[2].getContents();
					}
				}

				backLog = loWorkbook.getSheet(0);
			for (int i = 7; i < backLog.getRows();) {
				Cell[] cellArray = backLog.getRow(i);
				if (cellArray.length == 0)
					break;
				if (cellArray[0].getContents().equals("Unplanned"))
					typeFlag = true;

				cri = cellArray[1].getContents();
				if (!cellArray[1].getContents().equals("General")
						&& cellArray[0].getContents().length() != 0
						&& cellArray[1].getContents().length() != 0) {
					TaskInfo loTaskInfoObject = new TaskInfo(typeFlag);
					loTaskInfoObject.setCRIId(cellArray[1].getContents());
					loTaskInfoObject.setStoryType(cellArray[2].getContents());
					if(!cellArray[1].getContents().contains("."))
					{
						loTaskInfoObject.setStoryType("Tracker");
					}
					loTaskInfoObject.setTaskDesc(cellArray[3].getContents());
					loTaskInfoObject.setModule(cellArray[4].getContents());
					loTaskInfoObject.setStoryPoints(cellArray[7].getContents());
					if(loUTandReviewMap.get(cri) != null){
						loTaskInfoObject.setReviewCount(loUTandReviewMap.get(cri).getReviewCount());
						loTaskInfoObject.setUTCount(loUTandReviewMap.get(cri).getUTCount());}
						else{
							loTaskInfoObject.setReviewCount("0");
							loTaskInfoObject.setUTCount("0");}
					

					List<SubTaskInfo> loSubTaskInfo = new ArrayList<SubTaskInfo>();
					SubTaskInfo loSubTaskInfoObject = new SubTaskInfo();
					loSubTaskInfoObject.setTaskID(cellArray[0].getContents());
					loSubTaskInfoObject.setPlannedDate(cellArray[9]
							.getContents());
					loSubTaskInfoObject.setPriority(cellArray[6]
							.getContents());
					loSubTaskInfoObject.setActualDate(cellArray[10]
							.getContents());
					loSubTaskInfoObject
							.setTaskDesc(cellArray[11].getContents());
					loSubTaskInfoObject.setTeamMember(cellArray[12]
							.getContents());
					try{
					if (cellArray[13].getContents().length() > 0)
						loSubTaskInfoObject.setEstimatedHours(Integer
								.parseInt(cellArray[13].getContents()));
					if (cellArray[14].getContents().length() > 0)
						loSubTaskInfoObject.setActualHours(Integer
								.parseInt(cellArray[14].getContents()));
					}
					catch(Exception e)
					{
						System.out.println("Number format Exception");
					}
					loSubTaskInfoObject.setStatus(cellArray[15].getContents());
					loSubTaskInfoObject
							.setComments(cellArray[17].getContents());

					loSubTaskInfo.add(loSubTaskInfoObject);

					for (; i < backLog.getRows();) {
						cellArrayDup = backLog.getRow(++i);
						if (cellArrayDup.length == 0)
							break;
						if (!cellArrayDup[1].getContents().equals("General")
								&& cellArrayDup[0].getContents().length() != 0
								&& cellArrayDup[1].getContents().length() == 0) {
							loSubTaskInfoObject = new SubTaskInfo();
							loSubTaskInfoObject.setTaskID(cellArrayDup[0]
									.getContents());
							loSubTaskInfoObject.setPlannedDate(cellArrayDup[9]
									.getContents());
							loSubTaskInfoObject.setActualDate(cellArrayDup[10]
									.getContents());
							loSubTaskInfoObject.setPriority(cellArrayDup[6]
									.getContents());
							loSubTaskInfoObject.setTaskDesc(cellArrayDup[11]
									.getContents());
							loSubTaskInfoObject.setTeamMember(cellArrayDup[12]
									.getContents());
							try{
							if (cellArrayDup[13].getContents().length() > 0)
								loSubTaskInfoObject.setEstimatedHours(Integer
										.parseInt(cellArrayDup[13]
												.getContents()));
							if (cellArrayDup[14].getContents().length() > 0)
								loSubTaskInfoObject.setActualHours(Integer
										.parseInt(cellArrayDup[14]
												.getContents()));
						}
						catch(Exception e)
						{
							System.out.println("Exception "+e);
						}
							loSubTaskInfoObject.setStatus(cellArrayDup[15]
									.getContents());
							loSubTaskInfoObject.setComments(cellArrayDup[17]
									.getContents());
							loSubTaskInfo.add(loSubTaskInfoObject);
						} else
							break;
					}

					loTaskInfoObject.setLoSubTaskInfo(loSubTaskInfo);
					if(!(loTaskInfoObject.getLoSubTaskInfo().size() ==1 && loTaskInfoObject.getLoSubTaskInfo().get(0).getTaskDesc().equals("FT")))
					loTaskInfoList.add(loTaskInfoObject);
				} else
					i++;

			}

			// TODO Auto-generated method stub

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return loTaskInfoList;
	}

	@Override
	public boolean writeFile(List<TaskInfo> loTaskInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	 class UTandReview
	{
	String UTCount ="0";
	String ReviewCount = "0";

	public String getUTCount() {
		return UTCount;
	}

	public void setUTCount(String uTCount) {
		UTCount = uTCount;
	}

	public String getReviewCount() {
		return ReviewCount;
	}

	public void setReviewCount(String reviewCount) {
		ReviewCount = reviewCount;
	}


	}	
	
}
