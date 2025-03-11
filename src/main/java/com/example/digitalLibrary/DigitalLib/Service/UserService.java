package com.example.digitalLibrary.DigitalLib.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalLibrary.DigitalLib.Model.Author;
import com.example.digitalLibrary.DigitalLib.Model.Roles;
import com.example.digitalLibrary.DigitalLib.Model.Users;
import com.example.digitalLibrary.DigitalLib.Repository.RolesRepository;
import com.example.digitalLibrary.DigitalLib.Repository.UserRepository;
import com.example.digitalLibrary.DigitalLib.Request.UserRequest;

@Service
public class UserService {

	private UserRepository userRepo;
	private RolesRepository rolesRepo;
	private AuthorService authorService;
	
	@Autowired
	UserService(UserRepository userRepo, RolesRepository rolesRepo, AuthorService authorService){
		this.userRepo = userRepo;
		this.rolesRepo = rolesRepo;
		this.authorService = authorService;
	}
	
	public Users addUser(UserRequest userReq) {
		
		Set<Roles> roles = new HashSet<>(rolesRepo.findAllById(userReq.getRoleIds()));
		System.out.println(roles);
		
		Users user = new Users();
		user.setName(userReq.getName());
		user.setEmail(userReq.getEmail());
		user.setPassword(userReq.getPassword());
		user.setRoles(roles);
		
		boolean isAuthor = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("AUTHOR"));
		if (isAuthor) {
			Author author = new Author();
			author.setAuthorName(userReq.getName());
			author.setAuthorEmail(userReq.getEmail());
			System.out.println(authorService.addAuthor(author));
		}
		
		return userRepo.save(user);
	}
	
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
}
