package model;

public class RestaurantImgBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private int restaurantImgId;

	private byte[] img;
	
	private int restaurantId;
	
	public String toString() {
		return  "["+restaurantImgId + "," +img + "," + restaurantId + "]";
	}

	public int getRestaurantImgId() {
		return restaurantImgId;
	}

	public void setRestaurantImgId(int restaurantImgId) {
		this.restaurantImgId = restaurantImgId;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	

}
