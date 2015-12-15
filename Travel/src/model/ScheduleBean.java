package model;
public class ScheduleBean {
	private int scheduleId;
	private String scheduleName;
	private int memberId;
	
	
	@Override
	public String toString() {
		return "[" + scheduleId + "," + scheduleName +","+ memberId + "]";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
}
