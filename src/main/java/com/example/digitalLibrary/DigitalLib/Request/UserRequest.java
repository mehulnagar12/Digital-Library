package com.example.digitalLibrary.DigitalLib.Request;

import java.util.Set;

public class UserRequest {
	
	private String name;
	private String email;
	private String password;
	private Set<Integer> roleIds;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Set<Integer> roleIds) {
		this.roleIds = roleIds;
	}

}
