package model;

public class ThoughtBean {
	private int thoughtId;
	private String thoughtName;
	private String thoughtContent;
	private String thoughtType;
	private int memberId;
	
	
	@Override
	public String toString() {
		return "[" + thoughtId + "," + thoughtName + "," + thoughtContent
				+ ", " + thoughtType + "," + memberId + "]";
	}
	public int getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(int thoughtId) {
		this.thoughtId = thoughtId;
	}
	public String getThoughtName() {
		return thoughtName;
	}
	public void setThoughtName(String thoughtName) {
		this.thoughtName = thoughtName;
	}
	public String getThoughtContent() {
		return thoughtContent;
	}
	public void setThoughtContent(String thoughtContent) {
		this.thoughtContent = thoughtContent;
	}
	public String getThoughtType() {
		return thoughtType;
	}
	public void setThoughtType(String thoughtType) {
		this.thoughtType = thoughtType;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	} 
	
}
