package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping(path="/loan")
	public String getNotices() {
		return "Here are the loan details from db.";
	}
}
