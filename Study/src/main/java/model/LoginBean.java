package model;

public class LoginBean {
	// �ʵ�(�Ӽ�)
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
	
	// �α��� ����
	public boolean validate() {
		if (password.equals("admin")) // ��й�ȣ�� Ȯ����.
			return true;
		else 
			return false;
	}
}
