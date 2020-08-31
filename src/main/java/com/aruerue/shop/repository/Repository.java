package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.controller.dto.CartRespDto;
import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.detail.DetailProductRespDto;
import com.aruerue.shop.controller.dto.detail.DetailQnARespDto;
import com.aruerue.shop.controller.dto.detail.DetailRelatedRespDto;
import com.aruerue.shop.controller.dto.detail.DetailReviewRespDto;
import com.aruerue.shop.controller.dto.home.HomeAdResoDto;
import com.aruerue.shop.controller.dto.home.HomeNoticeRespDto;
import com.aruerue.shop.controller.dto.home.HomeProductRespDto;
import com.aruerue.shop.controller.dto.home.HomeReviewRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeDetailsRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeRespDto;
import com.aruerue.shop.controller.dto.qnA.CommentOnQnARespDto;
import com.aruerue.shop.controller.dto.qnA.QnARespDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;

public interface Repository {
	List<HomeAdResoDto> findHomeAd();
	List<HomeNoticeRespDto> findNotice();
	List<HomeProductRespDto> findProductsForHome();
	List<HomeReviewRespDto> findReviewsForHome();
	List<ShopRespDto> findProductsForShop();
	DetailProductRespDto findProductById(int id);
	List<DetailReviewRespDto> findReviewsById(int id);
	List<DetailQnARespDto> findQnAByIdForDetail(int id);
	List<DetailRelatedRespDto> findRelatedProductsById(int id);
	List<ReviewRespDto> findReviews();
	ReviewDetailRespDto findReviewById(int id);
	List<NoticeRespDto> findNotices();
	List<NoticeDetailsRespDto> findNoticeById(int id);
	List<QnARespDto> findQnAs();
	List<CartRespDto> findCartsById(int id);
	CommentOnQnARespDto findQnADetailById(int id);	
	
}
