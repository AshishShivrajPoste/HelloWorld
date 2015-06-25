import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class SprintBackLogTeamB extends XLFile {
	
	String Location = "TA_S<id>/SPB_TA_S<id>.xls";
	
	SprintBackLogTeamB(String sID) {
		Location = Location.replace("<id>", sID);
		setFileName(Location);
	}

	@Override
	public List<TaskInfo> readFile() {

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
				backLog = loWorkbook.getSheet(5);
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
				
				backLog = loWorkbook.getSheet(6);
				count = 1;
				cri = "";
				for (int i = 43; i < backLog.getRows();i++) {
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

				backLog = loWorkbook.getSheet(1);
			for (int i = 9; i < backLog.getRows();) {
				Cell[] cellArray = backLog.getRow(i);
				if (cellArray.length == 0)
					break;
				if (cellArray[2].getContents().equals("Unplanned"))
					typeFlag = true;

				cri = cellArray[2].getContents();
				if (!cellArray[2].getContents().equals("General") &&!cellArray[2].getContents().equals("Test") 
						&& cellArray[2].getContents().length() != 0
						&& cellArray[1].getContents().length() != 0) {
					TaskInfo loTaskInfoObject = new TaskInfo(typeFlag);
					loTaskInfoObject.setCRIId(cellArray[2].getContents());
					loTaskInfoObject.setStoryType(cellArray[3].getContents());
					loTaskInfoObject.setTaskDesc(cellArray[4].getContents());
					loTaskInfoObject.setModule(null);
					loTaskInfoObject.setStoryPoints(cellArray[7].getContents());
					if(loUTandReviewMap.get(cri) != null){
						loTaskInfoObject.setReviewCount(loUTandReviewMap.get(cri).getReviewCount());
						loTaskInfoObject.setUTCount(loUTandReviewMap.get(cri).getUTCount());}
						else{
							loTaskInfoObject.setReviewCount("0");
							loTaskInfoObject.setUTCount("0");}
					

					List<SubTaskInfo> loSubTaskInfo = new ArrayList<SubTaskInfo>();
					SubTaskInfo loSubTaskInfoObject = new SubTaskInfo();
					loSubTaskInfoObject.setTaskID(cellArray[1].getContents());
					loSubTaskInfoObject.setPlannedDate(cellArray[9]
							.getContents());
					loSubTaskInfoObject.setPriority(cellArray[8]
							.getContents());
					loSubTaskInfoObject.setStartDate(cellArray[10]
					                							.getContents());
					loSubTaskInfoObject.setActualDate(cellArray[11]
							.getContents());
					loSubTaskInfoObject
							.setTaskDesc(null);
					loSubTaskInfoObject.setTeamMember(cellArray[14]
							.getContents());
					try{
					if (cellArray[13].getContents().length() > 0)
						loSubTaskInfoObject.setEstimatedHours(Integer
								.parseInt(cellArray[12].getContents()));
					if (cellArray[14].getContents().length() > 0)
						loSubTaskInfoObject.setActualHours(Integer
								.parseInt(cellArray[13].getContents()));
					}
					catch(Exception e)
					{
						System.out.println("Number format Exception ="+cellArray[13].getContents()+"cri id "+cellArray[2].getContents());
						loSubTaskInfoObject.setEstimatedHours(0);
						loSubTaskInfoObject.setActualHours(0);
					}
					loSubTaskInfoObject.setStatus(cellArray[16].getContents());
					loSubTaskInfoObject
							.setComments(cellArray[17].getContents());

					loSubTaskInfo.add(loSubTaskInfoObject);

					for (; i < backLog.getRows();) {
						cellArrayDup = backLog.getRow(++i);
						if (cellArrayDup.length == 0)
							break;
						if (!cellArrayDup[1].getContents().equals("General")
								&& cellArrayDup[1].getContents().length() != 0
								&& cellArrayDup[2].getContents().length() == 0) {
							loSubTaskInfoObject = new SubTaskInfo();
							loSubTaskInfoObject.setTaskID(cellArrayDup[1]
									.getContents());
							loSubTaskInfoObject.setPlannedDate(cellArrayDup[9]
									.getContents());
							loSubTaskInfoObject.setStartDate(cellArray[10]
							                							.getContents());
							loSubTaskInfoObject.setActualDate(cellArrayDup[11]
									.getContents());
							loSubTaskInfoObject.setPriority(cellArrayDup[8]
									.getContents());
							loSubTaskInfoObject.setTaskDesc(cellArrayDup[4]
									.getContents());
							loSubTaskInfoObject.setTeamMember(cellArrayDup[14]
									.getContents());
							try{
							if (cellArrayDup[13].getContents().length() > 0)
								loSubTaskInfoObject.setEstimatedHours(Integer
										.parseInt(cellArrayDup[12]
												.getContents()));
							if (cellArrayDup[14].getContents().length() > 0)
								loSubTaskInfoObject.setActualHours(Integer
										.parseInt(cellArrayDup[13]
												.getContents()));
						}
						catch(Exception e)
						{
							System.out.println("Exception "+e+"cri id "+ cellArrayDup[14].getContents());
							loSubTaskInfoObject.setEstimatedHours(0);
							loSubTaskInfoObject.setActualHours(0);
						}
							loSubTaskInfoObject.setStatus(cellArrayDup[16]
									.getContents());
							loSubTaskInfoObject.setComments(cellArrayDup[17]
									.getContents());
							loSubTaskInfo.add(loSubTaskInfoObject);
						} else
							break;
					}

					loTaskInfoObject.setLoSubTaskInfo(loSubTaskInfo);
					if(!(loTaskInfoObject.getLoSubTaskInfo().size() ==1 && loTaskInfoObject.getLoSubTaskInfo().get(0).getTaskDesc()!=null && loTaskInfoObject.getLoSubTaskInfo().get(0).getTaskDesc().equals("FT")))
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
