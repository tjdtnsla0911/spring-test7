package com.aruerue.shop.controller.dto.detail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailRelatedRespDto {
	private int id;
	private String thumb;
	private String title;
	private int price;
	private int discounted;
	private String sale;
	private String newly;
	private String best;
	
	
}
