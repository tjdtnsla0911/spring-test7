package com.aruerue.shop.controller.dto.detail;

//r.userId, r.productId, r.content, r.star, r.createDate, r.orderId, r.img, username(서브쿼리), howToPay((서브쿼리)

import java.sql.Timestamp;

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
