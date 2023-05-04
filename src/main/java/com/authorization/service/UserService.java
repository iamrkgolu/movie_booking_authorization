package com.authorization.service;

import java.util.List;

import com.authorization.model.User;

public interface UserService {
	public User addUser(User user);// user registration

	public boolean loginUser(String loginid, String password);// login

	public List<User> getAllUsers();// will be visible only if you are logged in
}
