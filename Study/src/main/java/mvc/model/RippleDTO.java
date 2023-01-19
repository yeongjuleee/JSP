package mvc.model;

public class RippleDTO {
	private int rippleId;			// 리플 아이디
	private String boardName;		// 게시글 이름
	private int boardNum;			// 게시글 번호
	private String memberId;		// 작성자 아이디
	private String name;			// 작성자 이름
	private String content;			// 내용
	private String insertDate;		// 날짜
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
