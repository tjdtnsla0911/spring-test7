package com.aruerue.shop.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CartRespDto;
import com.aruerue.shop.controller.dto.QnARespDto;
import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.detail.DetailProductRespDto;
import com.aruerue.shop.controller.dto.detail.DetailQnARespDto;
import com.aruerue.shop.controller.dto.detail.DetailRelatedRespDto;
import com.aruerue.shop.controller.dto.detail.DetailReviewRespDto;
import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeDetailsRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeRespDto;
import com.aruerue.shop.controller.dto.responseDto.DetailResponseDto;
import com.aruerue.shop.controller.dto.responseDto.HomeResponseDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.repository.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class Controller {	
	private final Repository repository;

	@GetMapping({" ","/"})
	public String home() {		
		List<HomeAdResoDto> homeAdResoDtos = repository.findHomeAd();
		List<HomeNoticeRespDto> homeNoticeRespDtos = repository.findNotice();
		List<HomeProductRespDto> homeProductRespDtos = repository.findProductsForHome();
		List<HomeReviewRespDto> homeReviewRespDtos = repository.findReviewsForHome();
		
		HomeResponseDto homeResponseDto = HomeResponseDto.builder()
				.homeAdResoDto(homeAdResoDtos)
				.homeNoticeRespDto(homeNoticeRespDtos)
				.homeProductRespDto(homeProductRespDtos)
				.homeReviewRespDto(homeReviewRespDtos)
				.build();
		return homeResponseDto.getHomeAdResoDto()+" 메인화면입니다.";
	}
	
	@GetMapping("/shop")
	public String shop() {		
		List<ShopRespDto> ShopRespDtos = repository.findProductsForShop();		 
		return ShopRespDtos+ " shop화면 입니다.";
	}
	
	@GetMapping("/shop_view/{id}")
	public String shop_view(@PathVariable int id) {
		DetailProductRespDto detailProductRespDto = repository.findProductById(id);
		List<DetailReviewRespDto> detailReviewRespDto = repository.findReviewsById(id);
		List<DetailQnARespDto> detailQnARespDto = repository.findQnAById(id);
		List<DetailRelatedRespDto> detailRelatedRespDto = repository.findRelatedProductsById(id);
		
		DetailResponseDto detailResponseDto = DetailResponseDto.builder()
				.detailProductRespDto(detailProductRespDto)
				.detailReviewRespDto(detailReviewRespDto)
				.detailQnARespDto(detailQnARespDto)
				.detailRelatedRespDto(detailRelatedRespDto)
				.build();				
		return detailResponseDto.getDetailRelatedRespDto() +" 상품 디테일 페이지 입니다.";
	}
	
	@GetMapping("/review")
	public String review() {
		List<ReviewRespDto> reviewRespDto = repository.findReviews();		
		return reviewRespDto+"review 게시판 화면 입니다.";
	}
	
	@GetMapping("/review_detail/{id}")
	public String reviewDetail(@PathVariable int id) {
		ReviewDetailRespDto reviewDetailRespDto = repository.findReviewById(id);
		return reviewDetailRespDto+"review detail 화면 입니다.";
	}
		
	@GetMapping("/notice")
	public String notice() {
		List<NoticeRespDto> noticeRespDto = repository.findNotices();		
		return noticeRespDto+"notice 게시판 화면 입니다.";
	}
	
	@GetMapping("/notice_detail/{id}")
	public String notice_detail(@PathVariable int id) {
		List<NoticeDetailsRespDto> noticeDetailsRespDto = repository.findNoticeById(id);		
		return noticeDetailsRespDto+"notice detail 화면 입니다.";
	}
	
	@GetMapping("/qna")
	public String qna() {
		List<QnARespDto> qnARespDto = repository.findQnAs();
		return qnARespDto+"qna 게시판 화면 입니다.";
	}
	
	@GetMapping("/shop_cart/{userId}")
	public String cart(@PathVariable int userId) {
		List<CartRespDto> cartRespDto = repository.findCartsById(userId);
		return cartRespDto + "장바구니 화면입니다." ;
	}	
	
	
	
	
	
	
	
}
