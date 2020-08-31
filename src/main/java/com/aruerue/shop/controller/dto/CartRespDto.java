package com.aruerue.shop.controller.dto;

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.qnA.QnARespDto.QnARespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//p.id, p.title, c.quantity, p.price

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartRespDto {
	private int id;
	private String title;
	private String quantity;
	private int price;
}
