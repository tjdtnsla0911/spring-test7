package com.aruerue.shop.controller.dto.review;

import java.sql.Timestamp;

// r.img , u.profile, r.star, u.username, r.createDate, o.howToPay, r.content, p.thumb, p.title
public class ReviewDetailRespDto {
	private String img;
	private String profile;
	private int star;
	private String username;
	private Timestamp createDate;
	private String howToPay;
	private String content;
	private String thumb;
	private String title;
}
