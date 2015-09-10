package com.kainos.librarysystem.models;

public class Book {

	private String bookTitle;
	private String bookAuthor;
	private String bookCategory;
	private int bookPublishedYear;
	private int id;
	
	public Book(int id, String title, String author, String category, int pubYear) {
		this.id = id;
		bookTitle = title;
		bookAuthor = author;
		bookCategory = category;
		bookPublishedYear = pubYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getBookPublishedYear() {
		return bookPublishedYear;
	}
	
	public void setBookPublishedYear(int bookPublishedYear) {
		this.bookPublishedYear = bookPublishedYear;
	}
	
	

}
