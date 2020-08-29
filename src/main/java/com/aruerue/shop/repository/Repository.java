package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;

public interface Repository {
	List<HomeAdResoDto> findHomeAd();
	List<HomeNoticeRespDto> findNotice();
	List<HomeProductRespDto> findProducts();
	List<HomeReviewRespDto> findReviews();
	ShopRespDto findProductsByC(int id);

}
