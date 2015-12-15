package model;

public class SceneMessageBean implements java.io.Serializable{

	private int sceneMessageId;

	private String messageContent;

	private int memberId;
	
	private int sceneId;
	
	public String toString() {
		return  "["+sceneMessageId + "," +messageContent + "," + memberId + ","
				+ sceneId + "]";
	}

	public int getSceneMessageId() {
		return sceneMessageId;
	}

	public void setSceneMessageId(int sceneMessageId) {
		this.sceneMessageId = sceneMessageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		memberId = memberId;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		sceneId = sceneId;
	}

	
}
