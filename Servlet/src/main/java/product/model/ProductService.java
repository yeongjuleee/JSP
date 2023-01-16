package product.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	/*
		�����ͺ��̽� ���� ���� �����͸� MAP ���·� �����ϰ� ��ü ��ǰ ��ϰ�
		Ư�� ��ǰ�� ������ ��Ʈ�ѷ��� �����ϱ� ���� ���� Ŭ����
	*/
	
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		// �����ڸ� ���� MAP�� �߰�
		Product product = new Product("101", "���� ����� 12", "����", 1200000, "2020.12.12");
		products.put("101", product);
		product = new Product("102", "�Ｚ ������ 21", "�Ｚ����", 1300000, "2021.02.02");
		products.put("102", product);
		product = new Product("103", "���������", "��������", 1500000, "2021.03.02");
		products.put("103", product);
	}
	
	public List<Product> findAll() {
		// MAP�� ����Ʈ ���·� ��ȯ�ؼ� ����
		return new ArrayList<>(products.values());
	}
	
	public Product find(String id) {
		// ���ڷ� ���� Ű������ ��ǰ�� �˻��ؼ� Product ��ü�� ��ȯ
		return products.get(id);
	}
}
