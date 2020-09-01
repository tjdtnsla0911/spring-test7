package com.aruerue.shop.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CartRespDto;
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
import com.aruerue.shop.controller.dto.qnA.CommentOnQnARespDto;
import com.aruerue.shop.controller.dto.qnA.QnARespDto;
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
	public HomeResponseDto home() {		
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
		return homeResponseDto;
	}
	
	@GetMapping("/shop")
	public List<ShopRespDto> shop() {		
		List<ShopRespDto> ShopRespDtos = repository.findProductsForShop();		 
		return ShopRespDtos;
	}
	
	@GetMapping("/shop_view/{id}")
	public DetailResponseDto shop_view(@PathVariable int id) {
		DetailProductRespDto detailProductRespDto = repository.findProductById(id);
		List<DetailReviewRespDto> detailReviewRespDto = repository.findReviewsById(id);
		List<DetailQnARespDto> detailQnARespDto = repository.findQnAByIdForDetail(id);
		List<DetailRelatedRespDto> detailRelatedRespDto = repository.findRelatedProductsById(id);
		
		DetailResponseDto detailResponseDto = DetailResponseDto.builder()
				.detailProductRespDto(detailProductRespDto)
				.detailReviewRespDto(detailReviewRespDto)
				.detailQnARespDto(detailQnARespDto)
				.detailRelatedRespDto(detailRelatedRespDto)
				.build();				
		return detailResponseDto;
	}
	
	@GetMapping("/review")
	public List<ReviewRespDto> review() {
		List<ReviewRespDto> reviewRespDto = repository.findReviews();		
		return reviewRespDto;
	}
	
	@GetMapping("/review_detail/{id}")
	public ReviewDetailRespDto reviewDetail(@PathVariable int id) {
		ReviewDetailRespDto reviewDetailRespDto = repository.findReviewById(id);
		return reviewDetailRespDto;
	}
		
	@GetMapping("/notice")
	public List<NoticeRespDto> notice() {
		List<NoticeRespDto> noticeRespDto = repository.findNotices();		
		return noticeRespDto;
	}
	
	@GetMapping("/notice_detail/{id}")
	public List<NoticeDetailsRespDto> notice_detail(@PathVariable int id) {
		List<NoticeDetailsRespDto> noticeDetailsRespDto = repository.findNoticeById(id);		
		return noticeDetailsRespDto;
	}
	
	@GetMapping("/qna")
	public List<QnARespDto> qna() {
		List<QnARespDto> qnARespDto = repository.findQnAs();
		return qnARespDto;
	}
	
	@GetMapping("/qna_detail/{id}")
	public CommentOnQnARespDto qnaDetail(@PathVariable int id) {
		CommentOnQnARespDto mypageQnaDetailRespDto = repository.findQnADetailById(id);
		return mypageQnaDetailRespDto;
	}
	
	@GetMapping("/shop_cart/{userId}")
	public List<CartRespDto> cart(@PathVariable int userId) {
		List<CartRespDto> cartRespDto = repository.findCartsById(userId);
		return cartRespDto;
	}	
	
	
	
	
	
	
	
}
