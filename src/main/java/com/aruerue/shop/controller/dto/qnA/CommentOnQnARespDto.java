package com.aruerue.shop.controller.dto.qnA;

import java.security.Timestamp;

import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto.ReviewRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//u.profile, u.username, q.createDate, q.content, p.thumb, p.title, coq.createDate, coq.comment
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentOnQnARespDto {	
	private String profile;
	private String username;
	private Timestamp qCreateDate;
	private String content;
	private String thumb;
	private String title;
	private Timestamp coqCreateDate;
	private String comment;
	
}
