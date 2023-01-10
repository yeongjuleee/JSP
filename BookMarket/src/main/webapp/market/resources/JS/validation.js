function CheckAddBook() {
	let bookId = document.getElementById("bookId");
	let name = document.getElementById("name");
	let unitPrice = document.getElementById("unitPrice");
	let unitsInStock = document.getElementById("unitsInStock");
	//alert(productId.value);
	
	// 상품 아이디 체크
	if (!check(/^B[0-9]{3,11}$/, bookId,
		"[상품코드]\nB와 숫자를 조합하여 4~12자까지 입력하세요 \n첫 글자는 반드시 B로 시작하세요"))
		return false;
		
	// 상품명 체크
	if (name.value.length < 1 || name.value.length > 30) {
		alert("[도서명]\n최소 1자에서 최대 30자까지 입력하세요");
		name.select();
		name.focus();
		return false;
	}
	
	// 상품 가격 체크
	if (unitPrice.value.length == 0 || isNaN(unitPrice.value)) {
		alert("[가격]\n숫자만 입력하세요");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value < 0) {
		alert("[가격]\n음수를 입력할 수 없습니다.");
		unitPrice.select();
		unitPrice.focus();
		return false;
	} else if (!check(/^\d+(?:[.]?[\d]?[\d])?$/, unitPrice, "[가격]\n소수점 둘째 자리까지만 입력하세요."))
		return false;
	
	
	// 재고 수 체크
	if (isNaN(unitsInStock.value)) {
		alert("[재고 수]\n숫자만 입력하세요");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	function check(regExp, e, msg) {
		
		if(regExp.test(e.value)) {
			return true;
		}
		
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	
	document.newBook.submit();

}
	