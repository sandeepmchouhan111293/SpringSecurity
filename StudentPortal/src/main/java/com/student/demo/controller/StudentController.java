package com.student.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/getmessage")
	public String getMessage() {
		return "Welcome to Get Message";
	}
	
	@PostMapping("/postmessage")
	public String addMessage() {
		return "Welcome to Add Message";
	}
	
	@PutMapping("/updatemessage")
	public String updateMessage() {
		return "Welcome to Update Message";
	}
	
	@DeleteMapping("/deletemessage")
	public String deleteMessage() {
		return "Welcome to Delete Message";
	}
}
