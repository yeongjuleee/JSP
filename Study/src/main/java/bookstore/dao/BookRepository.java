package bookstore.dao;

import java.util.ArrayList;

import bookstore.dto.Book;
import market.dto.Product;

public class BookRepository {
	ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepository() {
		Book book1 = new Book("B1234", "�������� ���", 20000);
		book1.setAuthor("������");
		book1.setDescription("���ϰ� ���� ������� �������� ��¼��");
		book1.setPublisher("����Ʈ��B");
		book1.setCategory("������");
		book1.setUnitPrice(20);
		book1.setTotallPages(125);
		book1.setReleaseDate("12�� / 2022��");
		book1.setCondition("�Ű�");
		
		Book book2 = new Book("B1235", "�׸� �׸��� �;", 15000);
		book2.setAuthor("������");
		book2.setDescription("��̻�Ȱ�� �׸��� �׸��� ����� �����ϴ� ��¼��");
		book2.setPublisher("�׸�����");
		book2.setCategory("�̼�,����");
		book2.setUnitPrice(5);
		book2.setTotallPages(106);
		book2.setReleaseDate("12�� / 2021��");
		book2.setCondition("�߰���");
		
		Book book3 = new Book("B1236", "�� ��ȥ�� ������ ���ϰ� �Ǿ��ִ�", 20000);
		book3.setAuthor("������");
		book3.setDescription("�� ���� �̷� �� �ƴϾ��ݾ� ��¼��");
		book3.setPublisher("���̵ܹ��");
		book3.setCategory("E-book");
		book3.setUnitPrice(30);
		book3.setTotallPages(400);
		book3.setReleaseDate("11�� / 2022��");
		book3.setCondition("�Ű�");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public ArrayList<Book> getAllBooks() {
		return listOfBooks;
	}
}
