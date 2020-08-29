package com.aruerue.shop.controller.dto.review;

import java.sql.Timestamp;


import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//r.img , u.profile, r.star, u.username, r.createDate, o.howToPay, r.content, p.thumb, p.title, rc.createDate, rc.comment

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDetailRespDto {
	private String img;
	private String profile;
	private int star;
	private String username;
	private Timestamp rCreateDate;
	private String howToPay;
	private String content;
	private String thumb;
	private String title;
	private Timestamp rcCreateDate;
	private String comment;
}
