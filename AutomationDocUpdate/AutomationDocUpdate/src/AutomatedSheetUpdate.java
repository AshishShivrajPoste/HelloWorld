import java.util.*;

public class AutomatedSheetUpdate {

	public static void main(String args[]) throws Exception
	{
		XLFactory loFactory = new XLFactory();
		List taskInfoList = loFactory.createXLFile("06","SPB").readFile();
		boolean statusFlag = loFactory.createXLFile("06","RET").writeFile(taskInfoList);
		if(statusFlag)
			System.out.println("Successfully updated the  file");
		else
			System.out.println("Failed to update the  file");				
	}
}

