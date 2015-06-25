import java.util.*;

public abstract class XLFile {

	private String fileName = "//matrix/ALU/Muse/General/Working/Scrum/TA/";

	public abstract List<TaskInfo> readFile();
	public abstract boolean writeFile(List<TaskInfo> loTaskInfo);

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = this.fileName + fileName;
	}

}
