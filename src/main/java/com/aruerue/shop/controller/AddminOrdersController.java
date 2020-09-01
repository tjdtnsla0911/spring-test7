package com.aruerue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.addminDto.AddminOrdersDetailDto;
import com.aruerue.shop.addminDto.AddminOrdersDto;
import com.aruerue.shop.repository.AddminOrdersRepository;

@Controller
public class AddminOrdersController {

	@Value("${file.path}")
	private String fileRealPath;

	@Autowired
	AddminOrdersRepository addminOrdersRepository;

	AddminOrdersDto addminOrdersDto;
	@GetMapping("/orders")
	public String addminOrders(Model model,Model model2) {
		System.out.println("orders 값뿌리러왔쪙!");
		List<AddminOrdersDto> addminOrdersDto = addminOrdersRepository.findAllOrderList();
		List<AddminOrdersDetailDto> addminOrdersDto2 = addminOrdersRepository.findAllOrderDetailList();
		System.out.println("addminOrdersDto 찾아온값 = "+addminOrdersDto);
		model.addAttribute("orderList",addminOrdersDto);
		model.addAttribute("orderDetailList",addminOrdersDto2);
		System.out.println("addminOrdersDto = "+addminOrdersDto);
		return "addminOrdersList";
	}

	@PutMapping("/ordersDetail/{id}")
	public @ResponseBody List<AddminOrdersDetailDto> addminOrdersDetail(@PathVariable int id) {
		System.out.println("ordersDetil에옴");
		System.out.println("id= "+id);
		List<AddminOrdersDetailDto> add = addminOrdersRepository.findAllOrderDetailList2(id);
		System.out.println("뿌릴 add ?= "+add);
	//	System.out.println(addminOrdersRepository.findAllOrderDetailList2(id));
		return add;
	}

	@PutMapping("/chaneStats/{id}")
	public @ResponseBody String chaneStats(@PathVariable int id ,@RequestBody AddminOrdersDetailDto addminOrdersDetailDto) {
		System.out.println("일단왔고");
		System.out.println("id ="+id);
		System.out.println("addminOrdersDetailDto ="+addminOrdersDetailDto);
		System.out.println("이놈이아이디인가 ? ="+addminOrdersDetailDto.getOrders_detailId());
		System.out.println(addminOrdersDetailDto.getStats());//일단받았고
		addminOrdersRepository.updateOrders(addminOrdersDetailDto);
		System.out.println("일단끝낫듯");
		return "null";

	}


}

