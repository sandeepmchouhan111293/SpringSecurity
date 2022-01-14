package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping(path="/cards")
	public String getNotices() {
		return "Here are the cards details from db.";
	}
}
