package com.authorization.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(
	    name="USER", 
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"loginId", "email"})
	)
public class User {
	@Id
	private String loginId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;	
	private String contactNumber;
	public String getLoginId() {
		return loginId;
	}
	public String setLoginId(String loginId) {
		this.loginId = loginId;
		return loginId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String setFirstName(String firstName) {
		this.firstName = firstName;
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String setLastName(String lastName) {
		this.lastName = lastName;
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail(String email) {
		this.email = email;
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		this.password = password;
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return confirmPassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String setContactNumber(String contactNumber) {
		this.contactNumber=contactNumber;
		return contactNumber;
	}
	
	

}
