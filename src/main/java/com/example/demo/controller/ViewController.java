package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ViewController {
	@GetMapping("/post")
	public String viewPostPage() {
		return "post";
	}
}
