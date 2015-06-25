import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Retrospective extends XLFile {

	String Location = "TA_S<id>/Retrospective/RETRO_TA_S<id>.xls";

	Retrospective(String sID) {
		Location = Location.replace("<id>", sID);
		setFileName(Location);
	}

	@Override
	public List<TaskInfo> readFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeFile(List<TaskInfo> loTaskInfo) {
		boolean flag = true;
		Map loModuleMap = getSortedMap(loTaskInfo);
		try {
			File f1 = new File(
					"//matrix/ALU/Muse/General/Working/Scrum/TA/Template/Retrospective_template.xls");
			File f = new File(getFileName());
			Workbook workbook = Workbook.getWorkbook(f);
			WritableWorkbook copy = Workbook.createWorkbook(f, workbook);
			// TaskInfo loTaskInfoObject = null;
			WritableSheet sheet2 = copy.getSheet(1);
			WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 12);
			WritableCellFormat cellFormat = new WritableCellFormat(arial10font);
			cellFormat.setWrap(true);
			cellFormat.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
			Label label = null;
			jxl.write.Number loNumber = null;
			int pos = 2;

			Set<String> loKeySet = loModuleMap.keySet();
			for (String loModule : loKeySet) {

				Set<TaskInfo> tempTaskInfo = (Set) loModuleMap.get(loModule);
				for (TaskInfo loTaskInfoObject : tempTaskInfo) {
					if(loTaskInfoObject.getStatus().equalsIgnoreCase("Swapped"))
						continue;
					label = new Label(0, pos, loTaskInfoObject.getMember(),
							cellFormat);
			
					sheet2.addCell(label);
					label = new Label(1, pos, loTaskInfoObject.getCRIId(),
							cellFormat);
					
					sheet2.addCell(label);
					label = new Label(2, pos, loTaskInfoObject.getStoryType(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(3, pos, loTaskInfoObject.getModule(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(4, pos, loTaskInfoObject.getCRIId(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(5, pos, loTaskInfoObject.getTaskDesc(),
							cellFormat);
					sheet2.addCell(label);
					loNumber = new jxl.write.Number(6, pos, Integer
							.parseInt(loTaskInfoObject.getStoryPoints()),cellFormat);
					sheet2.addCell(loNumber);
					label = new Label(7, pos, loTaskInfoObject.getStatus(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(8, pos, loTaskInfoObject.getComments(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(9, pos, loTaskInfoObject.getLoSubTaskInfo().get(0).getStartDate(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(10, pos, loTaskInfoObject.getLoSubTaskInfo().get(loTaskInfoObject.getLoSubTaskInfo().size()-1).getActualDate(),
							cellFormat);
					sheet2.addCell(label);
					loNumber = new jxl.write.Number(11, pos, loTaskInfoObject
							.getActualHours(),cellFormat);
					sheet2.addCell(loNumber);
					label = new Label(13, pos, loTaskInfoObject.getCategory(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(21, pos, loTaskInfoObject.getUTCount(),
							cellFormat);
					sheet2.addCell(label);
					label = new Label(22, pos, loTaskInfoObject
							.getReviewCount(), cellFormat);
					sheet2.addCell(label);
					pos++;

				}
			}
			copy.write();
			copy.close();
			workbook.close();
		} catch (Exception e) {
		e.printStackTrace();
			flag = false;
		}
		return flag;

	}

	private Map getSortedMap(List<TaskInfo> loTaskInfo) {
		Map m = new TreeMap();
		String s = null;
		TaskInfo loTaskInfoObject = null;
		Set<TaskInfo> temp = null;
		for (int i = 0; i < loTaskInfo.size(); i++) {
			temp = new HashSet<TaskInfo>();
			loTaskInfoObject = loTaskInfo.get(i);
			temp.add(loTaskInfoObject);
			s = loTaskInfoObject.getLoSubTaskInfo().get(0).getTeamMember();
			for (int j = 0; j < loTaskInfo.size(); j++) {
				if (s.equals(loTaskInfo.get(j).getLoSubTaskInfo().get(0)
						.getTeamMember())) {
					temp.add(loTaskInfo.get(j));
				}
			}
			m.put(s, temp);
		}
		return m;
	}

}
