package com.aruerue.shop.controller.dto.responseDto;

import java.util.List;

import com.aruerue.shop.controller.dto.detail.DetailProductRespDto;
import com.aruerue.shop.controller.dto.detail.DetailQnARespDto;
import com.aruerue.shop.controller.dto.detail.DetailRelatedRespDto;
import com.aruerue.shop.controller.dto.detail.DetailReviewRespDto;

public class DetailResponseDto {
	DetailProductRespDto detailProductRespDto;
	List<DetailReviewRespDto> detailReviewRespDto;
	List<DetailQnARespDto> detailQnaRespDto;
	List<DetailRelatedRespDto> detailRelatedRespDto;
	
}
