package com.stg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.UserService;
import com.stg.entity.Constants;
import com.stg.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "user")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userLogin/{userName}/{userPassword}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> userLogin(@PathVariable String userName, @PathVariable String userPassword) {

		User user = userService.loginUser(userName, userPassword);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/createLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createLogin(@RequestBody User user) {

		User users = userService.createUser(user);

		return new ResponseEntity<User>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/authenticate")
	public Map<String, String> generateToken(@RequestBody User user) {
		long timestamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timestamp)).setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
				.claim("userId", user.getUserId()).claim("userName", user.getUserName()).compact();
		Map<String, String> map = new HashMap<>();

		map.put("JWT", token);
		return map;

	}

}
