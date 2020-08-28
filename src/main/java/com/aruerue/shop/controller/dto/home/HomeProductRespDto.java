package com.aruerue.shop.controller.dto.home;

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
public class HomeProductRespDto {
	
	private int id;
	private String thumb;
	private String title;
	private int price;
	private int discounted;
	private boolean sale;
	private boolean newly;
	private boolean best;

}
