package bookstore.dao;

import java.util.ArrayList;

import bookstore.dto.Book;

public class BookRepository {
	ArrayList<Book> listOfBooks = new ArrayList<Book>();
	// å ���
	
	private static BookRepository instance = new BookRepository();
	
	public static BookRepository getInstance() {
		return instance;
	}
	
	public BookRepository() { // å ����
		Book book1 = new Book("B1234", "�������� ���", 20000);
		// book1("åID", "å����", å����)
		
		book1.setAuthor("������");
		book1.setDescription("���ϰ� ���� ������� �������� ��¼��");
		book1.setPublisher("����Ʈ��B");
		book1.setCategory("������");
		book1.setUnitsInStock(20);
		book1.setTotallPages(125);
		book1.setReleaseDate("12�� / 2022��");
		book1.setCondition("�Ű�");
		book1.setFilename("B1234.jpg");
		
		Book book2 = new Book("B1235", "�׸� �׸��� �;", 15000);
		// book2("åID", "å����", å����)
		
		book2.setAuthor("������");
		book2.setDescription("��̻�Ȱ�� �׸��� �׸��� ����� �����ϴ� ��¼��");
		book2.setPublisher("�׸�����");
		book2.setCategory("�̼�,����");
		book2.setUnitsInStock(5);
		book2.setTotallPages(106);
		book2.setReleaseDate("12�� / 2021��");
		book2.setCondition("�߰���");
		book2.setFilename("B1235.jpg");
		
		Book book3 = new Book("B1236", "�� ��ȥ�� ������ ���ϰ� �Ǿ��ִ�", 20000);
		// book3("åID", "å����", å����)
		
		book3.setAuthor("������");
		book3.setDescription("�� ���� �̷� �� �ƴϾ��ݾ� ��¼��");
		book3.setPublisher("���̵ܹ��");
		book3.setCategory("E-book");
		book3.setUnitsInStock(30);
		book3.setTotallPages(400);
		book3.setReleaseDate("11�� / 2022��");
		book3.setCondition("�Ű�");
		book3.setFilename("B1236.png");
		
		// ���� å ��Ͽ� �߰�
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public ArrayList<Book> getAllBooks() { // ��Ͽ� ���� å ���� ��������
		return listOfBooks;
	}
	
	public Book getBookById(String BookId) { // ��Ͽ��� ��ǰ ���̵� ã�� �� ��ȯ
		Book bookById = null; // �ʱ� ��ǰ ���̵� ���� ���� ���� ���� 
		
		for(int i = 0; i < listOfBooks.size(); i++) { // ��ǰ ����� ������ŭ �ݺ�
			Book book = listOfBooks.get(i); // ��ǰ ����� �ε����� ���� product�� ���
			if (book != null && book.getBookId() != null && book.getBookId().equals(BookId)) {
				// ��ǰ�� ������� �ʰ�, ��ǰ�� ���̵� ������� �ʰ�, ��ǰ���̵� �ش� ��ǰ ���̵�� ������, 
				bookById = book;
				// ��ǰ���̵� ��ǰ�� ����
				break;
			}
		}
		return bookById; // ��ǰ�� ��������� null ��ȯ
	}
	
	public void addBook(Book book) {	// �߰� �κ�
		listOfBooks.add(book);
	}
}