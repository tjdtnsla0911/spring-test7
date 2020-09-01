package com.aruerue.shop.repository;

import com.aruerue.shop.model.Notice;
import com.aruerue.shop.model.product.Category;
import com.aruerue.shop.model.product.Product;
import com.aruerue.shop.model.product.RelatedProduct;
import com.aruerue.shop.model.qnA.Qna;
import com.aruerue.shop.model.review.Recomment;
import com.aruerue.shop.model.review.Review;
import com.aruerue.shop.model.user.Cart;
import com.aruerue.shop.model.user.Coupon;
import com.aruerue.shop.model.user.Orders;
import com.aruerue.shop.model.user.OrdersDetail;
import com.aruerue.shop.model.user.Point;
import com.aruerue.shop.model.user.User;
import com.aruerue.shop.model.user.WishList;

public interface TestRepository {
	Product getProduct(int id);
	Review getReview(int id);
	User getU(int id);
	Recomment getR(int id);
	Notice getN(int id);
	Qna getQ(int id);	
	Orders getO(int id);
	OrdersDetail getOd(int id);
	WishList getW(int id);
	Coupon getCoupon(int id);
	Point getPoint(int id);
	RelatedProduct getRp(int id);
	Category getCategory(int id);
	Cart getCart(int id);

}
