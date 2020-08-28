package com.aruerue.shop.controller.dto.detail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//select id, thumb, title, price, discounted, sale, newly, best, disc, content
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailProductRespDto {
	private int id;
	private String thumb;
	private String title;
	private int price;
	private int discounted;
	private boolean sale;
	private boolean newly;
	private boolean best;
	private String disc;
	private String content;
	
}
