package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.controller.dto.mypage.MypageCancleRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageCouponRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageOrdersResponseDto;
import com.aruerue.shop.controller.dto.mypage.MypagePointRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageQnaRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageUpdateRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageWishResponseDto;

public interface MyPageRepository {
	List<MypageOrdersResponseDto> findOrdersById(int id);
	List<MypageWishResponseDto> findWishlistsById(int id);
	List<MypageCancleRespDto> findCancleById(int id);
	List<MypageCouponRespDto> findCouponById(int id);
	List<MypagePointRespDto> findPointById(int id);
	List<MypageQnaRespDto> findQnaById(int id);
	MypageUpdateRespDto findUserById(int id);
	void deleteByid(int id);	

}
