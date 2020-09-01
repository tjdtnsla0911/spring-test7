package com.aruerue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
import com.aruerue.shop.repository.TestRepository;

@RestController
public class TestController {

	@Autowired
	private TestRepository testRepository;


	@GetMapping("/test/product/{id}")
	public Product product (@PathVariable int id) {
		Product p = testRepository.getProduct(id);
		return p;
	}

	@GetMapping("/test/review/{id}")
	public Review review(@PathVariable int id) {
		Review review = testRepository.getReview(id);
		return review;
	}

	@GetMapping("/test/user/{id}")
	public User user (@PathVariable int id) {
		User user = testRepository.getU(id);
		return user;
	}

	@GetMapping("/test/recomment/{id}")
	public Recomment recomment(@PathVariable int id) {
		Recomment recomment = testRepository.getR(id);
		return recomment;
	}

	@GetMapping("/test/notice/{id}")
	public Notice  notice(@PathVariable int id) {
		Notice n = testRepository.getN(id);
		return n;
	}

	@GetMapping("/test/qna/{id}")
	public Qna  qna(@PathVariable int id) {
			Qna q = testRepository.getQ(id);
		return q;
	}

	@GetMapping("/test/orders/{id}")
	public Orders  orders(@PathVariable int id) {
			Orders orders = testRepository.getO(id);
		return orders;
	}

	@GetMapping("/test/ordersDetail/{id}")
	public OrdersDetail  ordersDetail(@PathVariable int id) {
		OrdersDetail od = testRepository.getOd(id);
		return od;
	}

	@GetMapping("/test/wishlist/{id}")
	public WishList  wishlist(@PathVariable int id) {
		WishList w = testRepository.getW(id);
		return w;
	}

	@GetMapping("/test/coupon/{id}")
	public Coupon  coupon(@PathVariable int id) {
		Coupon coupon = testRepository.getCoupon(id);
		return coupon;
	}

	@GetMapping("/test/point/{id}")
	public Point  point(@PathVariable int id) {
		Point point = testRepository.getPoint(id);
		return point;
	}

	@GetMapping("/test/relatedProduct/{id}")
	public RelatedProduct  relatedProduct(@PathVariable int id) {
			RelatedProduct rp = testRepository.getRp(id);
		return rp;
	}

	@GetMapping("/test/category/{id}")
	public Category  category(@PathVariable int id) {
		Category category = testRepository.getCategory(id);
		return category;
	}

	@GetMapping("/test/cart/{id}")
	public Cart cart(@PathVariable int id) {
		Cart cart = testRepository.getCart(id);
		return cart;
	}



}
