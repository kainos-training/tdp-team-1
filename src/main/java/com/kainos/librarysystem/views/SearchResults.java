package com.kainos.librarysystem.views;

import io.dropwizard.views.View;

import java.util.List;

import com.kainos.librarysystem.models.Book;

public class SearchResults extends View {
	private List<Book> books;
	private String searchMessage;
	private String searchText;

	public SearchResults(List<Book> bookList, String searchMessage,
			String searchText) {
		super("/search-results.ftl");
		books = bookList;
		this.searchMessage = searchMessage;
		this.searchText = searchText;
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

	public String getSearchCriteria() {
		return searchText;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchText = searchCriteria;
	}
}