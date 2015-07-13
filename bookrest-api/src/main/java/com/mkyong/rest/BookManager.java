package com.mkyong.rest;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.mkyong.Book;

public class BookManager {

	private Map<String, Book> books = new ConcurrentHashMap<String, Book>();

	private static final BookManager instance = new BookManager();
	
	private BookManager() {
		
	}
	
	public static BookManager getInstance() {
		return instance;
	}
	
	public String createBook(Book book) {
		String bookId = UUID.randomUUID().toString();
		book.setBookId(bookId);
		books.put(bookId, book);
		return bookId;
	}
	
	public Book getBook(String bookId) {
		return books.get(bookId);
	}
	
	public Map<String, Book> getBooks() {
		Book book = new Book();
		book.setBookId(UUID.randomUUID().toString());
		book.setEditionYear(1991L);
		book.setEditorial("Salamandra");
		book.setAuthor("J. K. Rowling");
		book.setTitle("Harry Potter and the chamber of secrets");
		books.put(book.getBookId(), book);
		return books;
	}
	
	public boolean updateBook(String bookId, Book book) {
		if (books.containsKey(bookId)) {
			book.setBookId(bookId);
			books.put(bookId, book);
			return true;
		}
		return false;
	}
	
	public boolean deleteBook(String bookId) {
		if (books.containsKey(bookId)) {
			books.remove(bookId);
			return true;
		}
		return false;
	}
	
	public Book[] listBooks() {
		return books.values().toArray(new Book[books.size()]);
	}
	
	public boolean getBookById(String bookId) {
		Book book = books.get(bookId);
		if (book != null) {
			book.setBookId(bookId);
			return true;
		}
		return false;
	}
}
