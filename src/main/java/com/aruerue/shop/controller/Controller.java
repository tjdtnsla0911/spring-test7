package com.aruerue.shop.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;
import com.aruerue.shop.controller.dto.responseDto.HomeResponseDto;
import com.aruerue.shop.repository.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class Controller {
	
	private final Repository repository;


	@GetMapping({" ","/"})
	public String home() {		
		List<HomeAdResoDto> homeAdResoDto = repository.findHomeAd();
		List<HomeNoticeRespDto> homeNoticeRespDto = repository.findNotice();
		List<HomeProductRespDto> homeProductRespDto = repository.findProducts();
		List<HomeReviewRespDto> homeReviewRespDto = repository.findReviews();
		
		HomeResponseDto homeResponseDto = HomeResponseDto.builder()
				.homeAdResoDto(homeAdResoDto)
				.homeNoticeRespDto(homeNoticeRespDto)
				.homeProductRespDto(homeProductRespDto)
				.homeReviewRespDto(homeReviewRespDto)
				.build();
		return homeResponseDto.getHomeAdResoDto()+"메인화면입니다.";
	}

	
	@GetMapping("/shop")
	public String shop() {		
		List<ShopRespDto> ShopRespDtos = new ArrayList<ShopRespDto>();
		ShopRespDto shopRespDto1= repository.findProductsByC(1);
		ShopRespDto shopRespDto2= repository.findProductsByC(2);
		ShopRespDtos.add(shopRespDto1);
		ShopRespDtos.add(shopRespDto2);
		return ShopRespDtos+ "shop화면 입니다.";
	}
	
	@GetMapping("/shop_view/{id}")
	public String shop_view(@PathVariable int id) {
		
		return id +"상품 디테일 페이지 입니다.";
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
		return userId + "장바구니 화면입니다." ;
	}	
	

}
