package com.authorization.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorization.model.User;
import com.authorization.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
@RestController
@RequestMapping("auth/v1")
public class AuthController {
private Map<String, String> mapObj = new HashMap<String, String>();
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		if(userService.addUser(user)!=null)
	{
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
		return new ResponseEntity<String>("user registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//method to generate token inside login API
	public String generateToken(String username, String password) throws ServletException, Exception
	{
		String jwtToken;
		if(username ==null || password ==null)
		{
			throw new ServletException("Please enter valid credentials");
		}
		
		boolean flag = userService.loginUser(username, password);
		
		if(!flag)
		{
			throw new ServletException("Invalid credentials");
		}
		
		else
		{
			jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis()+300000))
						.signWith(SignatureAlgorithm.HS256, "secret key").compact();
						
		}
		
		return jwtToken;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> logiUser(@RequestBody User user)
	{
	
		try
		{
			String jwtToken = generateToken(user.getLoginId(), user.getPassword());
			mapObj.put("Message", "User successfully logged in");
			mapObj.put("Token:", jwtToken);
			
		}
		catch(Exception e)
		{
			mapObj.put("Message", "User not logged in");
			mapObj.put("Token:", null);
			return new ResponseEntity<>(mapObj, HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(mapObj, HttpStatus.OK);
	}
	
}
