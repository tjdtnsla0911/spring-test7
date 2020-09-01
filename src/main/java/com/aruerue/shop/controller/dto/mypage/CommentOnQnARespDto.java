package com.aruerue.shop.controller.dto.mypage;

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.mypage.MypageQnaRespDto.MypageQnaRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//q.createDate, q.content, p.thumb, p.title, coq.createDate, coq.comment

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentOnQnARespDto {
	private Timestamp qCreateDate;
	private String content;
	private String thumb;
	private String title;
	private  Timestamp coqCreateDate;
	private String comment;

}
