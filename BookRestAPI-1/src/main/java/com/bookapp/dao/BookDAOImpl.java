package com.bookapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
@Service
public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBooks() {
		return showBookList();
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> newBookList = new ArrayList<>();
		for(Book book : showBookList()) {
			if(book.getAuthor().equals(author))
				newBookList.add(book);
		}
		if(newBookList.isEmpty())
		{
			throw new BookNotFoundException("Author not available");
		}
		return newBookList;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		return showBookList().stream().filter((book)->book.getCategory().equals(category)).collect(Collectors.toList());
		
		
	}
	private List<Book> showBookList(){
		return Arrays.asList(new Book(1,"Learn Java","Kathy","Tech",900.0),
				new Book(2,"7 Habits","Steves","SelfHelp",1900.0),
				new Book(3,"Learn Python","KSC","Tech",800.0),
				new Book(1,"Learn HTML","Kathy","Tech",1900.0)
				);
				
	}
 
	@Override
	public Book getById(int id) throws BookNotFoundException {
		return showBookList()
				.stream()
				.filter((book)->book.getBookId()==id)
				.findAny()
				.orElseThrow(()->new BookNotFoundException("Id not found"));
		
	}

}
