package com.aricent.edu.cri.gl2;

import java.util.Date;

public class GL2TimerBean {

	private boolean timerflag= false;
	private Date loDate = null;
	
	public boolean isTimerflag() {
		return timerflag;
	}
	public void setTimerflag(boolean timerflag) {
		this.timerflag = timerflag;
	}
	public Date getLoDate() {
		return loDate;
	}
	public void setLoDate(Date loDate) {
		this.loDate = loDate;
	}
}
