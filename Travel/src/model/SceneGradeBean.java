package model;
public class SceneGradeBean {

	private int sceneId;
	private int memberId;
	private int evaluate;
	
	@Override
	public String toString() {
		return "SceneGradeBean [sceneId=" + sceneId + ", memberId=" + memberId + ", evaluate=" + evaluate + "]";
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
	public int getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
	
	
}
