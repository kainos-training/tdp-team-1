package com.kainos.librarysystem.views;

import com.kainos.librarysystem.models.Book;

import io.dropwizard.views.View;

public class BookDetails extends View {

	private Book book;
	
	public BookDetails(Book book) {
		super("/bookDetails.ftl");
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	

}
