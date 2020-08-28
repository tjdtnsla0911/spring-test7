package com.aruerue.shop.controller.dto.home;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// r.content, p.title, p.id, u.username
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeReviewRespDto {
	
	private String content;
	private String title;
	private int id;
	private String username;

}
