package com.aruerue.shop.controller.dto.notice;

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
public class NoticeRespDto {
	private int id;
	private String title;
	private Timestamp createDate;
	private int readCount;
}
