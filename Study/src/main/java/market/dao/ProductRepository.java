package market.dao;

import java.util.ArrayList;

import market.dto.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();
	
	private static ProductRepository instance = new ProductRepository();	// �߰� �κ�
	
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
		
		Product notebook = new Product("P1235", "LG PC �׷�", 1500000);
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
		
		// ��ǰ ��Ͽ� ��ǰ �߰�
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}
	
	public ArrayList<Product> getAllProducts() { // ��ǰ ����� ��ǰ ���� ��������
		return listOfProducts;
	}
	
	public Product getProductById(String productId) { // ��Ͽ��� ��ǰ ���̵� ã�� �� ��ȯ
		Product productById = null; // �ʱ� ��ǰ ���̵� ���� ���� ���� ���� 
		
		for(int i = 0; i < listOfProducts.size(); i++) { // ��ǰ ����� ������ŭ �ݺ�
			Product product = listOfProducts.get(i); // ��ǰ ����� �ε����� ���� product�� ���
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				// ��ǰ�� ������� �ʰ�, ��ǰ�� ���̵� ������� �ʰ�, ��ǰ���̵� �ش� ��ǰ ���̵�� ������, 
				productById = product;
				// ��ǰ���̵� ��ǰ�� ����
				break;
			}
		}
		return productById; // ��ǰ�� ��������� null ��ȯ
	}
	
	public void addProduct(Product product) {	// �߰� �κ�
		listOfProducts.add(product);
	}
}
