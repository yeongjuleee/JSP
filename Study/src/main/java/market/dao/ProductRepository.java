package market.dao;

import java.util.ArrayList;

import market.dto.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();
	
	private static ProductRepository instance = new ProductRepository();	// 추가 부분
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	public ProductRepository() {
		Product phone = new Product("P1234", "S22", 2000000);
		phone.setDescription("5inch, 1334X750 Renina FHD display, 8-megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Samsung");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		phone.setFilename("P1234.png");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("13.3-inch, IPS LED display, 5rd Generation Intel Core processors");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("LG");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refurbished");
		notebook.setFilename("P1235.png");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 500000);
		tablet.setDescription("212.8*125.6*6.6mm, Super AMOLED display, Octa-Core processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Samsung");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		tablet.setFilename("P1236.png");
		
		// 상품 목록에 상품 추가
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}
	
	public ArrayList<Product> getAllProducts() { // 상품 목록의 상품 정보 가져오기
		return listOfProducts;
	}
	
	public Product getProductById(String productId) { // 목록에서 상품 아이디 찾기 및 반환
		Product productById = null; // 초기 상품 아이디 값을 담을 변수 지정 
		
		for(int i = 0; i < listOfProducts.size(); i++) { // 상품 목록의 개수만큼 반복
			Product product = listOfProducts.get(i); // 상품 목록의 인덱스를 변수 product에 담기
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				// 상품이 비어있지 않고, 상품의 아이디가 비어있지 않고, 상품아이디가 해당 상품 아이디와 같으면, 
				productById = product;
				// 상품아이디에 상품을 담음
				break;
			}
		}
		return productById; // 상품이 비어있으면 null 반환
	}
	
	public void addProduct(Product product) {	// 추가 부분
		listOfProducts.add(product);
	}
}
