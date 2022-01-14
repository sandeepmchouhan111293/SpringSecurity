package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

	@GetMapping(path="/balance")
	public String getbalance() {
		return "Here are the balance details from db.";
	}
}
