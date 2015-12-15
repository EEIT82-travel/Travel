package model;

public class QBean {
	private int qId;
	private String QName;
	private String ans;
	private String a;
	private String b;
	private String c;
	private String d;
	
	@Override
	public String toString() {
		return "QBean [qId=" + qId + ", QName=" + QName + ", ans=" + ans + ", a=" + a + ", b=" + b + ", c=" + c + ", d="
				+ d + "]";
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getQName() {
		return QName;
	}
	public void setQName(String qName) {
		QName = qName;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
	
}
