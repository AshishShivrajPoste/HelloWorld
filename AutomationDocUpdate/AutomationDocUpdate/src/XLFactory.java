public class XLFactory {

	XLFile createXLFile(String sID, String fileName) {
		XLFile loXLFile = null;

		if (fileName.equals("IND"))
			loXLFile = new IndicatorBoard(sID);
		if (fileName.equals("RET"))
			loXLFile = new Retrospective(sID);
		if (fileName.equals("SPB"))
			loXLFile = new SprintBackLogTeamB(sID);

		return loXLFile;

	}

}
