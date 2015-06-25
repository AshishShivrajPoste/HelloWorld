import java.io.File;
import jxl.format.*;
import java.util.*;

import jxl.Range;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class IndicatorBoard extends XLFile {

	String Location = "TA_S<id>/IndicatorBoard_S<id>.xls";

	IndicatorBoard(String sID) {
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

		Map loModuleMap = getSortedMap(loTaskInfo);
		int begin = 2;
		boolean flag = true;

		try {
			int mergeCells = 0;
			File f1 = new File(
					"//matrix/ALU/Muse/General/Working/Scrum/TA/Template/Indicator_template.xls");
			File f = new File(getFileName());
			Workbook workbook = Workbook.getWorkbook(f);
			WritableWorkbook copy = Workbook.createWorkbook(f, workbook);
			WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 24);
			WritableCellFormat cellFormat = new WritableCellFormat(arial10font);
			cellFormat.setWrap(true);
			cellFormat.setAlignment(Alignment.CENTRE);
			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		    cellFormat.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
			TaskInfo loTaskInfoObject = null;
			WritableSheet sheet2 = copy.getSheet(0);
			Label label = null;
			int pos = 2;
			int beginFirst = 2;
			Set<String> loKeySet = loModuleMap.keySet();
			for (String loModule : loKeySet) {
				label = new Label(0, pos, loModule, cellFormat);
				sheet2.addCell(label);
				Set<TaskInfo> tempTaskInfo = (Set) loModuleMap.get(loModule);
				for (TaskInfo loTask : tempTaskInfo) {
					label = new Label(1, pos, loTask.getCRIId(), cellFormat);
					sheet2.addCell(label);
					label = new Label(2, pos, loTask.getStoryType(), cellFormat);
					sheet2.addCell(label);
					label = new Label(3, pos, loTask.getLoSubTaskInfo().get(0)
							.getPriority(), cellFormat);
					sheet2.addCell(label);
					label = new Label(4, pos, loTask.getTaskDesc(), cellFormat);
					sheet2.addCell(label);
					List<SubTaskInfo> loSubTaskInfo = loTask.getLoSubTaskInfo();
					mergeCells = loSubTaskInfo.size();

					for (int j = 0; j < loSubTaskInfo.size(); j++) {
						label = new Label(8, pos, loSubTaskInfo.get(j)
								.getTaskID(), cellFormat);
						sheet2.addCell(label);
						label = new Label(9, pos, loSubTaskInfo.get(j)
								.getTaskDesc(), cellFormat);
						sheet2.addCell(label);
						pos++;
					}
					sheet2.mergeCells(1, begin, 1, pos - 1);
					sheet2.mergeCells(2, begin, 2, pos - 1);
					sheet2.mergeCells(3, begin, 3, pos - 1);
					sheet2.mergeCells(4, begin, 4, pos - 1);
					begin = pos;
				}

				sheet2.mergeCells(0, beginFirst, 0, pos - 1);
				beginFirst = pos;
				
			}

			copy.write();
			copy.close();
			workbook.close();

		} catch (Exception e) {
			System.out.println(e);
			flag = false;

		}

		return flag;
	}

	private void merge(WritableSheet sheet, Map loMap) {

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
			s = loTaskInfoObject.getModule();
			for (int j = 0; j < loTaskInfo.size(); j++) {
				if (s.equalsIgnoreCase(loTaskInfo.get(j).getModule())) {
					temp.add(loTaskInfo.get(j));
				}
			}
			m.put(s, temp);
		}
		return m;
	}

}
