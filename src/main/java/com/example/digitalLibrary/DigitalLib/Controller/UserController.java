package com.example.digitalLibrary.DigitalLib.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalLibrary.DigitalLib.Model.Roles;
import com.example.digitalLibrary.DigitalLib.Model.Users;
import com.example.digitalLibrary.DigitalLib.Service.RolesService;

@RestController
public class UserController {
	
	private RolesService rolesService;
	
	@Autowired
	UserController(RolesService rolesService){
		this.rolesService = rolesService;
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
	public Users addUser(@RequestBody Users user) {
		return null;
	}
}
