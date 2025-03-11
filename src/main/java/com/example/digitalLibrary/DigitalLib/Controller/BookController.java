package com.example.digitalLibrary.DigitalLib.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalLibrary.DigitalLib.Model.Books;
import com.example.digitalLibrary.DigitalLib.Request.BookRequest;
import com.example.digitalLibrary.DigitalLib.Service.BooksService;


@RestController
public class BookController {
	
	private BooksService bookService;
	
	BookController(BooksService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping("/addBook")
	public Books addBook(@RequestBody BookRequest bookRequest) {
		return bookService.addBook(bookRequest);
	}
	
	@GetMapping("/getBooks")
	public List<Books> booksList(){
		return bookService.getAllBooks();
	}
	
	@DeleteMapping("deleteBook/{bookId}")
	public List<Books> deleteBookById(@RequestParam int bookId){
		return bookService.deleteBookById(bookId);
	}
	
	@PutMapping("updateBook/{bookId}")
	public Books updateBookById(@RequestBody BookRequest bookRequest, @PathVariable int bookId) {
		System.out.println(bookRequest.getBookName() +  bookId);
		return bookService.updateBookById(bookRequest, bookId);
	}
}
