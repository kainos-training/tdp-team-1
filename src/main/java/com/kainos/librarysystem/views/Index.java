package com.kainos.librarysystem.views;

import io.dropwizard.views.View;

import java.util.ArrayList;
import java.util.List;

import com.kainos.librarysystem.models.Book;

public class Index extends View {

	private List<Book> books;

	public Index(List<Book> bookList) {
		super("/index.ftl");
		books = bookList;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
