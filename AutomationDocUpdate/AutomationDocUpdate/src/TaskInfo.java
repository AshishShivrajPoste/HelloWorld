import java.util.*;

public class TaskInfo {

	private String CRIId;
	private String taskDesc;
	private String storyPoints;
	private List<SubTaskInfo> loSubTaskInfo;
	private String Module;
	private String storyType;
	private String Category = "Planned";
	private String ReviewCount;
	private String UTCount;

	TaskInfo(boolean flag) {
		if (flag)
			Category = "UnPlanned";
	}

	
	public String getReviewCount() {
		return ReviewCount;
	}


	public void setReviewCount(String reviewCount) {
		ReviewCount = reviewCount;
	}


	public String getUTCount() {
		return UTCount;
	}


	public void setUTCount(String uTCount) {
		UTCount = uTCount;
	}


	public String getModule() {
		return Module;
	}

	public void setModule(String module) {
		this.Module = module;
	}

	public String getStoryType() {
		return storyType;
	}

	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getCRIId() {
		return CRIId;
	}

	public void setCRIId(String cRIId) {
		CRIId = cRIId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(String storyPoints) {
		this.storyPoints = storyPoints;
	}

	public List<SubTaskInfo> getLoSubTaskInfo() {
		return loSubTaskInfo;
	}

	public void setLoSubTaskInfo(List<SubTaskInfo> loSubTaskInfo) {
		this.loSubTaskInfo = loSubTaskInfo;
	}

	public int getActualHours() {
		int value = 0;
		for (int i = 0; i < loSubTaskInfo.size(); i++)
			value = value + loSubTaskInfo.get(i).getActualHours();
		return value;
	}

	public int getEstimatedHours() {
		int value = 0;
		for (int i = 0; i < loSubTaskInfo.size(); i++)
			value = value + loSubTaskInfo.get(i).getEstimatedHours();
		return value;
	}

	public String getMember() {
		return loSubTaskInfo.get(0).getTeamMember();
	}

	public String getStatus() {
		for (int i = loSubTaskInfo.size() - 1; i >= 0; i--) {
			String s = loSubTaskInfo.get(i).getStatus();
			if ((s != null && s.length() != 0 && !s.equals("Not_Started")))
				return s;
		}

		return loSubTaskInfo.get(loSubTaskInfo.size() - 1).getStatus();
	}

	public String getComments() {
		for (int i = loSubTaskInfo.size() - 1; i >= 0; i--) {
			String s = loSubTaskInfo.get(i).getComments();
			if (s != null && s.length() != 0)
				return s;
		}

		return loSubTaskInfo.get(loSubTaskInfo.size() - 1).getComments();
	}
   public boolean equals(Object o)
   {
	   if(((TaskInfo)o).CRIId == this.CRIId)
		   return true;
	   return false;
	   
   }
   
   public String toString()
   {
	   return this.CRIId;
   }
	
}
