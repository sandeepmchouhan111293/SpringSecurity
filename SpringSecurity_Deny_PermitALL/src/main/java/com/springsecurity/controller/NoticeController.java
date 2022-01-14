package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

	@GetMapping(path="/notices")
	public String getNotices() {
		return "Here are the notice details from db.";
	}
}
