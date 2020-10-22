package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.model.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDAO bookDAO;
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDAO.getAllBooks();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookDAO.getByAuthor(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
		return bookDAO.getByCategory(category);
	}

	@Override
	public Book getById(int id) {
		return bookDAO.getById(id);
	}

}
