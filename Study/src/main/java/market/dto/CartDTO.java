package market.dto;

public class CartDTO {
	// 필드(속성)
	private int cartId;			// 카트 고유 번호
	private String p_memberId;	// 회원아이디
	private String p_orderNum;	// 주문번호
	private String p_id;		// 상품코드
	private String p_name;		// 상품이름
	private long p_unitPrice;	// 상품가격
	private int p_subTotal;		// 소계
	private int p_count;		// 상품갯수
	private String p_note;		// 비고
	
	
	// Getter Setter 
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	public String getP_id() {
		return p_id;
	}
	
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	public String getP_name() {
		return p_name;
	}
	
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
	public long getP_unitPrice() {
		return p_unitPrice;
	}
	
	public void setP_unitPrice(long p_unitPrice) {
		this.p_unitPrice = p_unitPrice;
	}
	
	public int getP_count() {
		return p_count;
	}
	
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	
	public int getP_subTotal() {
		return p_subTotal;
	}
	
	public void setP_subTotal(int p_subTotal) {
		this.p_subTotal = p_subTotal;
	}
	
	public String getP_note() {
		return p_note;
	}
	
	public void setP_note(String p_note) {
		this.p_note = p_note;
	}
	
	public String getP_orderNum() {
		return p_orderNum;
	}
	
	public void setP_orderNum(String p_orderNum) {
		this.p_orderNum = p_orderNum;
	}
	public String getP_memberId() {
		return p_memberId;
	}
	
	public void setP_memberId(String p_memberId) {
		this.p_memberId = p_memberId;
	}
	
	
	
}
