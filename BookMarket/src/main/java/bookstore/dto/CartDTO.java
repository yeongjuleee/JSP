package bookstore.dto;

public class CartDTO {
	// �ʵ�(�Ӽ�)
	private int cartId;			// īƮ ���� ��ȣ
	private String b_memberId;	// ȸ�����̵�
	private String b_orderNum;	// �ֹ���ȣ
	private String b_id;		// ��ǰ�ڵ�
	private String b_name;		// ��ǰ�̸�
	private long b_unitPrice;	// ��ǰ����
	private int b_subTotal;		// �Ұ�
	private int b_count;		// ��ǰ����
	private String b_note;		// ���
	
	
	// Getter Setter 
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	public String getB_id() {
		return b_id;
	}
	
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	
	public String getB_name() {
		return b_name;
	}
	
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	
	public long getB_unitPrice() {
		return b_unitPrice;
	}
	
	public void setB_unitPrice(long b_unitPrice) {
		this.b_unitPrice = b_unitPrice;
	}
	
	public int getB_count() {
		return b_count;
	}
	
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	
	public int getB_subTotal() {
		return b_subTotal;
	}
	
	public void setB_subTotal(int b_subTotal) {
		this.b_subTotal = b_subTotal;
	}
	
	public String getB_note() {
		return b_note;
	}
	
	public void setB_note(String b_note) {
		this.b_note = b_note;
	}
	
	public String getB_orderNum() {
		return b_orderNum;
	}
	
	public void setB_orderNum(String b_orderNum) {
		this.b_orderNum = b_orderNum;
	}
	public String getB_memberId() {
		return b_memberId;
	}
	
	public void setB_memberId(String b_memberId) {
		this.b_memberId = b_memberId;
	}
	
	
	
}
