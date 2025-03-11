package com.example.digitalLibrary.DigitalLib.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalLibrary.DigitalLib.Model.Roles;
import com.example.digitalLibrary.DigitalLib.Model.Users;
import com.example.digitalLibrary.DigitalLib.Request.UserRequest;
import com.example.digitalLibrary.DigitalLib.Service.RolesService;
import com.example.digitalLibrary.DigitalLib.Service.UserService;

@RestController
public class UserController {
	
	private RolesService rolesService;
	private UserService userService;
	
	@Autowired
	UserController(RolesService rolesService, UserService userService){
		this.rolesService = rolesService;
		this.userService = userService;
	}
	
	@PostMapping("/addRoles")
	public Roles addRole(@RequestBody Roles role) {
		return rolesService.addRoles(role);
	}
	
	@GetMapping("/rolesList")
	public List<Roles> getAllRoles(){
		return rolesService.getAllRoles();
	}
	
	@PostMapping("/addUser")
	public Users addUser(@RequestBody UserRequest userReq) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		userReq.setPassword(encoder.encode(userReq.getPassword()));
		
		return userService.addUser(userReq);
	}
	
	@GetMapping("/usersList")
	public List<Users> usersList(){
		return userService.getAllUsers();
	}
}
