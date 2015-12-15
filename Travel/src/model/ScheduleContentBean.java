package model;
public class ScheduleContentBean {

	private int scheduleContentId;
	private int scheduleOrder;
	private int sceneId;
	private int scheduleId;
	
	
	@Override
	public String toString() {
		return "[行程id："+ scheduleContentId + ",行程順序：" + scheduleOrder
				+ ",景點id：" + sceneId + ",行程id：" + scheduleId + "]";
	}
	public int getScheduleContentId() {
		return scheduleContentId;
	}
	public void setScheduleContentId(int scheduleContentId) {
		this.scheduleContentId = scheduleContentId;
	}
	public int getScheduleOrder() {
		return scheduleOrder;
	}
	public void setScheduleOrder(int scheduleOrder) {
		this.scheduleOrder = scheduleOrder;
	}
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
	
}
