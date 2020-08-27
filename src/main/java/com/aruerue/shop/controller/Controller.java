package com.aruerue.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping({" ","/"})
	public String home() {
		return "메인화면입니다.";
	}
	
	@GetMapping("/shop")
	public String shop() {
		return "shop화면 입니다.";
	}
	
	@GetMapping("/shop_view/{id}")
	public String shop_view(@PathVariable int id) {
		
		return "상품 디테일 페이지 입니다.";
	}
	
	@GetMapping("/review")
	public String review() {
		return "review 게시판 화면 입니다.";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "notice 게시판 화면 입니다.";
	}
	
	@GetMapping("/qna")
	public String qna() {
		return "qna 게시판 화면 입니다.";
	}
	
	@PostMapping("/shop_cart/{userId}")
	public String cart(@PathVariable int userId) {
		return "장바구니 화면입니다." ;
	}	
	

}
