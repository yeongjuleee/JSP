package model;

public class LoginBean {
	// 필드(속성)
	private String id;
	private String password;
	
	// Getter Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 로그인 인증
	public boolean validate() {
		if (password.equals("admin")) // 비밀번호만 확인함.
			return true;
		else 
			return false;
	}
}
