package com.aruerue.shop.controller.dto.mypage;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// od.orderId, od.productId, od.quantity, od.stats, p.title, p.thumb
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MypageCancleRespDto {
	private int orderId;
	private int productId;
	private String quantity; //지우고 싶음...
	private String stats;
	private String title;
	private String thumb;
	
	
}
