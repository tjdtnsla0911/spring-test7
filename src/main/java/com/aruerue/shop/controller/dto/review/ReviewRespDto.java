package com.aruerue.shop.controller.dto.review;

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// r.id, p.title, r.content, u.username, r.createDate, r.star
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRespDto {
	private int id;
	private String title;
	private String content;
	private String username;
	private Timestamp createDate;
	private int star;
	//////////////////
	private int count;
	private int photoCount;
	

}
