package com.example.digitalLibrary.DigitalLib.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalLibrary.DigitalLib.Model.Author;
import com.example.digitalLibrary.DigitalLib.Repository.AuthorRepository;

@Service
public class AuthorService {
	
	private AuthorRepository authorRepo;
	
	@Autowired
	AuthorService(AuthorRepository authorRepo){
		this.authorRepo = authorRepo;
	}
	
	public String addAuthor(Author author) {
		try {
			authorRepo.save(author);
			return "Author added successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
