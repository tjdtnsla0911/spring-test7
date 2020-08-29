package com.aruerue.shop.controller.dto.home;

import com.aruerue.shop.controller.dto.home.HomeAdResoDto.HomeAdResoDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeNoticeRespDto {
	private int id;
	private String thumb;
}
