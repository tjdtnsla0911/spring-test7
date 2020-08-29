package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.controller.dto.mypage.MypageOrdersResponseDto;

public interface MyPageRepository {
	List<MypageOrdersResponseDto> findById(int id);

}
