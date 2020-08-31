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
public class MypageCouponRespDto {
	private int id;
	private String code;
	private Timestamp validityStart;
	private Timestamp validityEnd;
	private int availability;

}
