package model;
public class RestaurantGradeBean {
	private int restaurantId;
	private int memberId;
	private Integer evaluate;
	
	@Override
	public String toString() {
		return "[restaurantId=" + restaurantId + ", memberId=" + memberId + ", evaluate=" + evaluate
				+ "]";
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
	public Integer getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(Integer evaluate) {
		this.evaluate = evaluate;
	}
	
	
}
