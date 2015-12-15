package model;
public class CollectBean {

	private int memberId;
	private int sceneId;
	private Integer collectId;
	
	
	@Override
	public String toString() {
		return "[memberId:" + memberId + ", sceneId:" + sceneId + ", collectId:" + collectId + "]";
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public Integer getCollectId() {
		return collectId;
	}
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	
	
}
