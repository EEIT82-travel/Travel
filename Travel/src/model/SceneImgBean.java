package model;

public class SceneImgBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
		
	private int sceneImgId;

	private byte[] img;
	
	private int sceneId;
	
	public String toString() {
		return  "["+sceneImgId + "," +img + "," + sceneId + "]";
	}

	public int getSceneImgId() {
		return sceneImgId;
	}

	public void setSceneImgId(int sceneImgId) {
		this.sceneImgId = sceneImgId;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	
	

}
