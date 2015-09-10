package com.kainos.librarysystem.views;

import io.dropwizard.views.View;

import java.util.List;

import com.kainos.librarysystem.models.Book;

public class SearchResults extends View {
	private List<Book> books;
	private String searchMessage;

	public SearchResults(List<Book> bookList, String searchMessage) {
		super("/search-results.ftl");
		books = bookList;
		this.searchMessage = searchMessage;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getSearchMessage() {
		return searchMessage;
	}

	public void setSearchMessage(String searchMessage) {
		this.searchMessage = searchMessage;
	}
}