package com.aruerue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aruerue.shop.model.Notice;
import com.aruerue.shop.repository.AddminNoticeRepository;

@Controller
public class AddminNoticeController {

	@Autowired
	AddminNoticeRepository addminNoticeRepository;
	@GetMapping("/noticelist")
	public String NoticeList(Model model) {
		List<Notice> noticeList = addminNoticeRepository.findAllNotice();
		System.out.println("가져온 notice들은 ?="+noticeList);
		model.addAttribute("noticeList",noticeList);

		System.out.println("addminNotice에 보내기직전");
		return "addminNotice";
	}

	@GetMapping("/selectNotice/{id}")
	public String selectNotice(@PathVariable int id) {
		System.out.println("왔음");
		System.out.println("받은 id="+id);
		//System.out.println("받은 id = ?"+id);
		return "null";

	}
}
