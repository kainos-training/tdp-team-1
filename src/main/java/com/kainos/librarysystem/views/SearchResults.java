package com.kainos.librarysystem.views;

import io.dropwizard.views.View;

import java.util.List;

import com.kainos.librarysystem.models.Book;

public class SearchResults extends View {
	private List<Book> books;
	private String searchMessage;
	private String searchCriteria;

	public SearchResults(List<Book> bookList, String searchMessage,
			String searchCriteria) {
		super("/search-results.ftl");
		books = bookList;
		this.searchMessage = searchMessage;
		this.searchCriteria = searchCriteria;
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

	String getSearchCriteria() {
		return searchCriteria;
	}

	void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
}