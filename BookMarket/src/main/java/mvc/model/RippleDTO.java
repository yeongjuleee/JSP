package mvc.model;

public class RippleDTO {
	private int rippleId;			// ���� ���̵�
	private String boardName;		// �Խñ� �̸�
	private int boardNum;			// �Խñ� ��ȣ
	private String memberId;		// �ۼ��� ���̵�
	private String name;			// �ۼ��� �̸�
	private String content;			// ����
	private String insertDate;		// ��¥
	private String ip;				// IP
	
	// getter setter
	public int getRippleId() {
		return rippleId;
	}
	public void setRippleId(int rippleId) {
		this.rippleId = rippleId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
