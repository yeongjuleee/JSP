package bookstore.dao;

import java.util.ArrayList;

import bookstore.dto.Book;
import market.dto.Product;

public class BookRepository {
	ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepository() {
		Book book1 = new Book("B1234", "집에가는 방법", 20000);
		book1.setAuthor("나저자");
		book1.setDescription("격하게 집에 가고싶은 현대인의 어쩌고");
		book1.setPublisher("스마트웹B");
		book1.setCategory("에세이");
		book1.setUnitPrice(20);
		book1.setTotallPages(125);
		book1.setReleaseDate("12월 / 2022년");
		book1.setCondition("신간");
		
		Book book2 = new Book("B1235", "그림 그리고 싶어서", 15000);
		book2.setAuthor("나지음");
		book2.setDescription("취미생활로 그림을 그리는 방법은 쉽습니다 어쩌고");
		book2.setPublisher("그림공장");
		book2.setCategory("미술,예술");
		book2.setUnitPrice(5);
		book2.setTotallPages(106);
		book2.setReleaseDate("12월 / 2021년");
		book2.setCondition("중고도서");
		
		Book book3 = new Book("B1236", "이 결혼은 어차피 망하게 되어있다", 20000);
		book3.setAuthor("김차차");
		book3.setDescription("너 원래 이런 애 아니었잖아 어쩌고");
		book3.setPublisher("팝콘미디어");
		book3.setCategory("E-book");
		book3.setUnitPrice(30);
		book3.setTotallPages(400);
		book3.setReleaseDate("11월 / 2022년");
		book3.setCondition("신간");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public ArrayList<Book> getAllBooks() {
		return listOfBooks;
	}
}
