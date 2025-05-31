package ch08.unit11;

import java.util.Objects;

public class Ex04 {
	public static void main(String[] args) {
		Book b = new Book("자바", "1234");
		System.out.println(b.title() + ", " + b.author() + ", " + b.isbn());
		
		// Book b2 = new Book("자바", null, "1234");
			// 런타임 오류 
	}
}

record Book(String title, String author, String isbn) {
	// 컴팩트 생성자
	// public Book (String title, String author, String isbn) {} 와 동일
	public Book {
		// Objects.requireNonNull(객체)
		//  : 객체가 null 인경우 NullPointerException 발생
		Objects.requireNonNull(title);
		Objects.requireNonNull(author);
		Objects.requireNonNull(isbn);
	}
	
	// 표준 생성자와 컴팩트 생성자를 혼용하여 사용 가능
	public Book(String title, String isbn) {
		this(title, "UnKnown", isbn);
	}
}