package model;
public class MemberMessageBean {

	private int memberMessageID;
	private String memberMessageContent;
	private String messaageTime;
	private int memberId;
	
	@Override
	public String toString() {
		return "[MemberMessageID=" + memberMessageID + ", MemberMessageContent="
				+ memberMessageContent + ", MessaageTime=" + messaageTime + ", memberId=" + memberId + "]";
	}

	public int getMemberMessageID() {
		return memberMessageID;
	}

	public void setMemberMessageID(int memberMessageID) {
		this.memberMessageID = memberMessageID;
	}

	public String getMemberMessageContent() {
		return memberMessageContent;
	}

	public void setMemberMessageContent(String memberMessageContent) {
		this.memberMessageContent = memberMessageContent;
	}

	public String getMessaageTime() {
		return messaageTime;
	}

	public void setMessaageTime(String messaageTime) {
		this.messaageTime = messaageTime;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
