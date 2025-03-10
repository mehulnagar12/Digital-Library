package com.example.digitalLibrary.DigitalLib.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalLibrary.DigitalLib.Model.Roles;
import com.example.digitalLibrary.DigitalLib.Repository.RolesRepository;

@Service
public class RolesService {
	
	private RolesRepository rolesRepo;
	
	@Autowired
	RolesService(RolesRepository rolesRepo){
		this.rolesRepo = rolesRepo;
	}
	
	public Roles addRoles(Roles role) {
		return rolesRepo.save(role);
	}

	public List<Roles> getAllRoles() {
		return rolesRepo.findAll();
	}

}
