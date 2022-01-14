package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping(path="/account")
	public String getAccount() {
		return "Here are the account details.";
	}
}
