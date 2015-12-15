package model;

public class RestaurantMessageBean implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;

	private int restaurantMessageId;

	private String messageContent;
	
	private int restaurantId;
	
	private int memberId;
	
	public String toString() {
		return  "["+restaurantMessageId + "," +messageContent + "," + restaurantId + ","
				+ memberId + "]";
	}

	public int getRestaurantMessageId() {
		return restaurantMessageId;
	}

	public void setRestaurantMessageId(int restaurantMessageId) {
		this.restaurantMessageId = restaurantMessageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
}
