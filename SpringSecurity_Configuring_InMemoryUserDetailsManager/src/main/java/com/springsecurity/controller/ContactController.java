package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@GetMapping(path="/contact")
	public String getContactDetails() {
		return "Here are the contact details from db";
	}
}
