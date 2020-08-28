package com.aruerue.shop.controller.dto.mypage;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//배송비는 고정
//p.id, p.title, c.quantity, p.price
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MypageCartResponseDto {
	private int id;
	private String title;
	private int quantity;
	private int price;	

}
