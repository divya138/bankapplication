package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Login;
import com.account.service.UserService;
@RestController
public class LoginController {
	@Autowired
	UserService userservice;

	@PostMapping("/login123")
	ResponseEntity<Login> login(@RequestBody Login login) {
		Login login1 = userservice.addUser(login);
		return new ResponseEntity<Login>(login1, HttpStatus.OK);

	}

	@GetMapping("/logincustomer")
	public boolean loginValidation(@RequestParam long customerId) {
		boolean login = userservice.loginValidation(customerId);
		return login;

	}

}
