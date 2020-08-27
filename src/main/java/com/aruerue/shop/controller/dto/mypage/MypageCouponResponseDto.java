package com.aruerue.shop.controller.dto.mypage;

import java.sql.Timestamp;

public class MypageCouponResponseDto {
	private int id;
	private String code;
	private Timestamp validityStart;
	private Timestamp validityEnd;
	private int availability;

}
