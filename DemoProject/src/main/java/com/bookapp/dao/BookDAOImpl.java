package com.bookapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.model.Book;

public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBooks() {
		return showBookList();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		List<Book> newBookList = new ArrayList<>();
		for(Book book : showBookList()) {
			if(book.getAuthor().equals(author))
				newBookList.add(book);
		}
		
		return newBookList;
	}

	@Override
	public List<Book> getByCategory(String category) {
		List<Book> newBookList = new ArrayList<>();
		for(Book book : showBookList()) {
			if(book.getAuthor().equals(category))
				newBookList.add(book);
		}
		
		return null;
	}
	private List<Book> showBookList(){
		return Arrays.asList(new Book(1,"Learn Java","Kathy","Tech",900.0),
				new Book(2,"7 Habits","Steves","SelfHelp",1900.0),
				new Book(3,"Learn Python","KSC","Tech",800.0),
				new Book(1,"Learn HTML","Kathy","Tech",1900.0)
				);
				
	}
 
	@Override
	public Book getById(int id) {
		for(Book book:showBookList()) {
			if(book.getBookId()==id)
				return book;
		}
		return null;
		
	}

}
