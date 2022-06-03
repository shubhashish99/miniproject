package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.UserService;
import com.stg.entity.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> userLogin(@RequestBody String userName, @RequestParam String userPassword) {

		User user = userService.loginUser(userName, userPassword);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/createLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createLogin(@RequestBody User user) {

		User users = userService.createUser(user);

		return new ResponseEntity<User>(users, HttpStatus.OK);
	}

	@PutMapping(value = "/updateLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateLogin(@RequestBody User user) {

		User users = userService.updateUser(user);

		return new ResponseEntity<User>(users, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteLogin(@RequestBody User user) {

		userService.deleteUser(user);

		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
