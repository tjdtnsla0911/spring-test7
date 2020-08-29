package com.aruerue.shop.controller.dto.mypage;

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
public class MypageQnaRespDto {
	private int id;
	private String title;
	private String content;
	private Timestamp createDate;

}
