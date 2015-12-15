package model;

public class RestaurantBean implements java.io.Serializable{

	private int restaurantId;

	private String location;

	private String city;

	private String restaurantName;

	private String restaurantContent;
	
	private String timeStart;

	private String timeEnd;

	private String price;

	private String telephone;

	private int evaluate;

	private String fans;

	private int memberId;
	
	public String toString() {
		return  "["+restaurantId + "," +location + "," + city + ","
				+ restaurantName + "," + restaurantContent + "," + timeStart + "," + timeEnd
				+ "," + price +","+ telephone + "," + evaluate + "," + fans
				+ memberId +"]";
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantContent() {
		return restaurantContent;
	}

	public void setRestaurantContent(String restaurantContent) {
		this.restaurantContent = restaurantContent;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}

	public String getFans() {
		return fans;
	}

	public void setFans(String fans) {
		this.fans = fans;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	
}
