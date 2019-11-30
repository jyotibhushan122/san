package org.movie.constent;

public enum TimeConstent {
	IST_SHOW("10:00", "01:00"),SECOND_SHOW("02:00", "05:00"),THIRD_SHOW("06:00", "09:00");

	private String startTime;
	private String endTime;

	private TimeConstent(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
}
