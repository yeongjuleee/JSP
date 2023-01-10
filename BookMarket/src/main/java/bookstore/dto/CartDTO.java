package bookstore.dto;

public class CartDTO {
	// 필드(속성)
	private int cartId;			// 카트 고유 번호
	private String b_memberId;	// 회원아이디
	private String b_orderNum;	// 주문번호
	private String b_id;		// 상품코드
	private String b_name;		// 상품이름
	private long b_unitPrice;	// 상품가격
	private int b_subTotal;		// 소계
	private int b_count;		// 상품갯수
	private String b_note;		// 비고
	
	
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
