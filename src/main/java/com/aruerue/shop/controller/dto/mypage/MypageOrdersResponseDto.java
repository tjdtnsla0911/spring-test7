package com.aruerue.shop.controller.dto.mypage;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MypageOrdersResponseDto {
	
	// o.id, o.orderDate, o.totalPrice, o.howToPay, od.stats, p.title, o.userId
	private int id;
	private Timestamp orderDate;
	private int totalPrice;
	private String howToPay;
	private String stats;
	private String title;
	private int userId;
	
}
