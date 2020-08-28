package com.aruerue.shop.controller.dto.detail;

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//q.answer, q.title, u.username, q.createDate, p.id
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailQnARespDto {
	private boolean answer;
	private String title;
	private String username;
	private Timestamp createDate;
	private int id;
	
	}
