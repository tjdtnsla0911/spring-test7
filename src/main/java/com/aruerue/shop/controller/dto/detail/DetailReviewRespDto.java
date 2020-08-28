package com.aruerue.shop.controller.dto.detail;

//r.userId, r.productId, r.content, r.star, r.createDate, r.orderId, r.img, username(서브쿼리), howToPay((서브쿼리)

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailReviewRespDto {
	private int userId;
	private int productId;
	private String content;
	private int star;
	private Timestamp createDate;
	private int orderId;
	private String img;
	private String username;
	private String howToPay;
	
}
