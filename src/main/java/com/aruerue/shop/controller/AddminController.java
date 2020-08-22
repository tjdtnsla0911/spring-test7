package com.aruerue.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddminController {
	@GetMapping("/axios")
	public String index() {
		return "index";
	}

}
