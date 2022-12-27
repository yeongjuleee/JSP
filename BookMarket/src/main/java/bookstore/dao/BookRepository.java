package bookstore.dao;

import java.util.ArrayList;

import bookstore.dto.Book;

public class BookRepository {
	ArrayList<Book> listOfBooks = new ArrayList<Book>();
	// 책 목록
	
	private static BookRepository instance = new BookRepository();
	
	public static BookRepository getInstance() {
		return instance;
	}
	
	public BookRepository() { // 책 정보
		Book book1 = new Book("B1234", "집에가는 방법", 20000);
		// book1("책ID", "책제목", 책가격)
		
		book1.setAuthor("나저자");
		book1.setDescription("격하게 집에 가고싶은 현대인의 어쩌고");
		book1.setPublisher("스마트웹B");
		book1.setCategory("에세이");
		book1.setUnitsInStock(20);
		book1.setTotallPages(125);
		book1.setReleaseDate("12월 / 2022년");
		book1.setCondition("신간");
		book1.setFilename("B1234.jpg");
		
		Book book2 = new Book("B1235", "그림 그리고 싶어서", 15000);
		// book2("책ID", "책제목", 책가격)
		
		book2.setAuthor("나지음");
		book2.setDescription("취미생활로 그림을 그리는 방법은 쉽습니다 어쩌고");
		book2.setPublisher("그림공장");
		book2.setCategory("미술,예술");
		book2.setUnitsInStock(5);
		book2.setTotallPages(106);
		book2.setReleaseDate("12월 / 2021년");
		book2.setCondition("중고도서");
		book2.setFilename("B1235.jpg");
		
		Book book3 = new Book("B1236", "이 결혼은 어차피 망하게 되어있다", 20000);
		// book3("책ID", "책제목", 책가격)
		
		book3.setAuthor("김차차");
		book3.setDescription("너 원래 이런 애 아니었잖아 어쩌고");
		book3.setPublisher("팝콘미디어");
		book3.setCategory("E-book");
		book3.setUnitsInStock(30);
		book3.setTotallPages(400);
		book3.setReleaseDate("11월 / 2022년");
		book3.setCondition("신간");
		book3.setFilename("B1236.png");
		
		// 만든 책 목록에 추가
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public ArrayList<Book> getAllBooks() { // 목록에 담은 책 정보 가져오기
		return listOfBooks;
	}
	
	public Book getBookById(String BookId) { // 목록에서 상품 아이디 찾기 및 반환
		Book bookById = null; // 초기 상품 아이디 값을 담을 변수 지정 
		
		for(int i = 0; i < listOfBooks.size(); i++) { // 상품 목록의 개수만큼 반복
			Book book = listOfBooks.get(i); // 상품 목록의 인덱스를 변수 product에 담기
			if (book != null && book.getBookId() != null && book.getBookId().equals(BookId)) {
				// 상품이 비어있지 않고, 상품의 아이디가 비어있지 않고, 상품아이디가 해당 상품 아이디와 같으면, 
				bookById = book;
				// 상품아이디에 상품을 담음
				break;
			}
		}
		return bookById; // 상품이 비어있으면 null 반환
	}
	
	public void addBook(Book book) {	// 추가 부분
		listOfBooks.add(book);
	}
}