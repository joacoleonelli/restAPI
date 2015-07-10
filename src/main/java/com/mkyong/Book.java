package com.mkyong;

public class Book {

	Long editionYear;
	String title;
	String author;
	String editorial;
	
	public Long getEditionYear() {
		return editionYear;
	}
	public void setEditionYear(Long editionYear) {
		this.editionYear = editionYear;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", editionYear=" + editionYear + ", author=" + author + ", editorial=" + editorial + "]";
	}
}
