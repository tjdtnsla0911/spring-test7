package com.aruerue.shop.controller.dto.responseDto;

import java.util.List;

import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class HomeResponseDto {
	List<HomeAdResoDto> homeAdResoDto;
	List<HomeNoticeRespDto> homeNoticeRespDto;
	List<HomeProductRespDto> homeProductRespDto;
	List<HomeReviewRespDto> homeReviewRespDto;
}
