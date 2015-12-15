package model;
public class ImpeachBean {

	private int impeachId;
	private Integer restaurantId;
	private Integer restaurantMessageId;
	private Integer thoughtId;
	private Integer sceneMessageId;
	private Integer sceneId;
	private String impeach;
	private String inpeachTime;
	
	
	
	@Override
	public String toString() {
		return "ImpeachBean [impeachId=" + impeachId + ", restaurantId=" + restaurantId + ", restaurantMessageId="
				+ restaurantMessageId + ", thoughtId=" + thoughtId + ", sceneMessageId=" + sceneMessageId + ", sceneId="
				+ sceneId + ", impeach=" + impeach + ", inpeachTime=" + inpeachTime + "]";
	}
	public int getImpeachId() {
		return impeachId;
	}
	public void setImpeachId(int impeachId) {
		this.impeachId = impeachId;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Integer getRestaurantMessageId() {
		return restaurantMessageId;
	}
	public void setRestaurantMessageId(Integer restaurantMessageId) {
		this.restaurantMessageId = restaurantMessageId;
	}
	public Integer getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(Integer thoughtId) {
		this.thoughtId = thoughtId;
	}
	public Integer getSceneMessageId() {
		return sceneMessageId;
	}
	public void setSceneMessageId(Integer sceneMessageId) {
		this.sceneMessageId = sceneMessageId;
	}
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getImpeach() {
		return impeach;
	}
	public void setImpeach(String impeach) {
		this.impeach = impeach;
	}
	public String getInpeachTime() {
		return inpeachTime;
	}
	public void setInpeachTime(String inpeachTime) {
		this.inpeachTime = inpeachTime;
	}
	
}
