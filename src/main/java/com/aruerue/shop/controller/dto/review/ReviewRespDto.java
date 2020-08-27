package com.aruerue.shop.controller.dto.review;

import java.sql.Timestamp;

// r.id, p.title, r.content, u.username, r.createDate, r.star
public class ReviewRespDto {
	private int id;
	private String title;
	private String content;
	private String username;
	private Timestamp createDate;
	private int star;

}
