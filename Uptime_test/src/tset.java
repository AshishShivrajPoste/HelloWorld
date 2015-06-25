
public class tset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUptime());
	}
	
	/**
	 * return types handled
	 * > 22:19:55 up 7 days, 17:14,  3 users,  load average: 2.73, 2.87, 2.91
	 * > 17:52:38 up 12:45,  0 users,  load average: 0.88, 1.08, 1.15
	 * > 05:02:57 up 8 days, 14 min,  0 users,  load average: 0.07, 0.06, 0.01
	 * > 15:26:02 up 49 min,  2 users,  load average: 2.45, 3.27, 2.38
	 * @return
	 */
	public static String getUptime(){
		//TraceManager.TrMethod(" --IN--");
		
		String upTime ="0d 0h 0m";

		String dat = null;  
		//TraceManager.TrDebug("NPOSERVERPROXY::: uptime called");
		dat = "22:19:55 up 7 days, 17:14,  3 users,  load average: 2.73, 2.87, 2.91"; 
		System.out.println(dat.split(",")[0].split(" ")[0]);
		//TraceManager.TrDebug("NPOSERVERPROXY::: dat value is "+dat);
		try{
			int days = 0;
			int i=0;
			int hours =0;
			int mins =0;
	
			dat=dat.trim();
			if(dat.contains("day")&& !(dat.contains("min"))){
				days = Integer.parseInt(dat.split(",")[0].trim().split(" ")[2]);
				//TraceManager.TrDebug("days value is "+days);
				hours = Integer.parseInt(dat.split(",")[1].trim().split(":")[0]);
				//TraceManager.TrDebug("hours value is "+hours);
				mins = Integer.parseInt(dat.split(",")[1].trim().split(":")[1]);
				//TraceManager.TrDebug("mins value is "+mins);

				//TraceManager.TrDebug("upTime value is "+upTime);
			}else if(dat.contains("day")&& (dat.contains("min"))){
				days = Integer.parseInt(dat.split(",")[0].trim().split(" ")[2]);
				mins = Integer.parseInt(dat.split(",")[1].trim().split(" ")[0]);
			}
			else if(!dat.contains("day") && dat.contains("min")) {
				mins = Integer.parseInt(dat.split(",")[0].split(" ")[2]);

			}else{
				hours = Integer.parseInt(dat.split(",")[0].trim().split(" ")[2].split(":")[0]);
				mins = Integer.parseInt(dat.split(",")[0].trim().split(" ")[2].split(":")[1]);
			}
			upTime = days+"d "+hours+"h "+mins+"m";	  
		}
		catch(Exception e){
			//TraceManager.TrError("Issue in fetching uptime default value applied on upTime: "+e);
		
		}
		//TraceManager.TrMethod(" --OUT--");
		return upTime;
	}

}



