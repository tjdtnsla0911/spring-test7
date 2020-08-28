package com.aruerue.shop.controller.dto;

import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// c.type, p.categoryId, p.thumb, p.title, p.price, p.discounted, p.sale, p.newly, p.best
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopRespDto {
	private String type;
	private int categoryId;
	private String thumb;
	private String title;
	private int price;
	private int discounted;
	private boolean sale;
	private boolean newly;
	private boolean best;
}
