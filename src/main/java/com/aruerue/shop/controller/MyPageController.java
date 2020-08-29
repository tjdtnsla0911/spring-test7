package com.aruerue.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.mypage.MypageOrdersResponseDto;
import com.aruerue.shop.repository.MyPageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MyPageController {
	
	private final MyPageRepository myPageRepository;

	@PostMapping("/shop_mypage/{userId}/order")
	public String mypageOrder(@PathVariable int userId) {
		List<MypageOrdersResponseDto> mypageOrdersResponseDto = (List<MypageOrdersResponseDto>) myPageRepository.findById(userId);
		return mypageOrdersResponseDto+"마이페이지 주문조회 화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/wish_list")
	public String mypageWish(@PathVariable int userId) {
		
		return "마이페이지 WishList 화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/cancle")
	public String mypageCart(@PathVariable int userId) {
		
		return "마이페이지  취소/교환/반품 화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/coupon")
	public String mypageCoupon(@PathVariable int userId) {
		
		return "마이페이지 쿠폰화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/point")
	public String mypagePoint(@PathVariable int userId) {
		
		return "마이페이지 포인트 화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/qna")
	public String mypageQnA(@PathVariable int userId) {
		
		return "마이페이지 1:1 문의  화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/update")
	public String mypageUpdate(@PathVariable int userId) {
		
		return "마이페이지 회원정보 수정  화면 입니다.";
	}
	
	@PostMapping("/shop_mypage/{userId}/Withdrawal")
	public String mypageWithdrawal(@PathVariable int userId) {
		
		return "마이페이지 회원탈퇴  화면 입니다.";
	}
	
	
	
}
