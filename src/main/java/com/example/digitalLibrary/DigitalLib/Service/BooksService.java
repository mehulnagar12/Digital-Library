package com.example.digitalLibrary.DigitalLib.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.digitalLibrary.DigitalLib.Model.Author;
import com.example.digitalLibrary.DigitalLib.Model.Books;
import com.example.digitalLibrary.DigitalLib.Repository.AuthorRepository;
import com.example.digitalLibrary.DigitalLib.Repository.BooksRepo;
import com.example.digitalLibrary.DigitalLib.Request.BookRequest;

@Service
public class BooksService {
	
	private BooksRepo booksRepo;
	private AuthorRepository authorRepo;
	
	BooksService(BooksRepo booksRepo, AuthorRepository authorRepo) {
		this.booksRepo = booksRepo;
		this.authorRepo = authorRepo;
	}
	
	public Books addBook(BookRequest bookRequest) {
		Books books = new Books();
		Author author = authorRepo.findById(bookRequest.getAuthorId()).orElse(null);
		
		books.setAuthor(author);
		books.setBookName(bookRequest.getBookName());
		
		return booksRepo.save(books);
	}
	
	public List<Books> getAllBooks(){
		return booksRepo.findAll();
	}
	
	public List<Books> deleteBookById(int bookId){
		booksRepo.deleteById(bookId);
		return booksRepo.findAll();
	}
	
	public Books updateBookById(BookRequest bookRequest, int bookId) {
		Books book = booksRepo.findById(bookId).orElse(null);
		System.out.println(bookRequest.getBookName());
		if (book != null) {
			System.out.println("Book Found: " + book.getBookName());
			book.setBookName(bookRequest.getBookName());
			Author author = authorRepo.findById(bookRequest.getAuthorId()).orElse(null);
			book.setAuthor(author);
			
			return booksRepo.save(book);
		} else {
			return addBook(bookRequest);
		}
	}
}
