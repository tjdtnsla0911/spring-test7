package com.aruerue.shop.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aruerue.shop.addminDto.AddminQnaDto;
import com.aruerue.shop.model.product.Product;
import com.aruerue.shop.model.product.Product_status;
import com.aruerue.shop.model.qnA.Qna;
import com.aruerue.shop.model.user.User;
import com.aruerue.shop.repository.AddminQnaRepository;
import com.aruerue.shop.repository.AddminRepository;
import com.aruerue.shop.repository.UserRepository;

@Controller
public class AddminQnaController {

	@Autowired
	AddminRepository addminRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddminQnaRepository AddminQnaRepository;

	@Value("${file.path}")
	private String fileRealPath;

	private User user;

	private Qna qna;

	private Product product;

	private Product_status product_status;

	private AddminQnaDto addminQnaDto;



	//Qna리스트로 이동
	@GetMapping("/addqna")
	public  String qnaList(Model model) {
		System.out.println("addqna에 왔습니다");
		List<AddminQnaDto> qnaList = AddminQnaRepository.qnaList();
		//여기서 답변 확인함
		String isTrue = "답변완료";
		String isFalse = "답변대기중";

		for( int i=0; i<=qnaList.size()-1;i++) {
			if(	qnaList.get(i).isAnswer()==true) {
				System.out.println("isAnswer이 true라면");
				qnaList.get(i).setAnswer2(isTrue);

			}else {
				System.out.println("isAnswer이 false 라면");
				qnaList.get(i).setAnswer2(isFalse);

			}



			}

		model.addAttribute("qnaList",qnaList);
		System.out.println(qnaList);
		System.out.println("무사히다마치고 addminQnaList로 보냅니다 ^^");
		return "addminQnaList";
	}

	//삭제
	@DeleteMapping("/qnaDelete/{id}")
	public @ResponseBody String qnaDelete(@PathVariable int id) {
		System.out.println("qnaDelete로 왔습니다");
		AddminQnaRepository.qnaDelete(id);
		return "OK";

	}
	//여기가 답변하러가는곳
	@GetMapping("/anwser")
	public String Qnarecomment(Model model,Model model2,@ModelAttribute AddminQnaDto addminQnaDto) {
		System.out.println("anwser에 답변하러옴");
		System.out.println("받은 addminDto = "+addminQnaDto);
		List<AddminQnaDto> addminDtos = AddminQnaRepository.selectQnaComment(addminQnaDto);

		//		if(addminDtos.size()>0) {
//
//		}
		model2.addAttribute("recoment", addminDtos);
		System.out.println("어드민 디티오 = "+addminDtos);
		model.addAttribute("addminQnaDto",addminQnaDto);
		//System.out.println("가져온 id = "+qna.getId());
		return "/addminQnaRecomment";

	}

	@PutMapping("/qnaUpdate/{id}")
	public @ResponseBody String qnaUpdate(@PathVariable int id,@RequestBody AddminQnaDto addminQnaDto) {
		System.out.println("qnaUpdate에 왔습니다");
		System.out.println("addminQnaDto = "+addminQnaDto);
		System.out.println("addminQnaDto = "+id);
		System.out.println("겟코멘트 = "+addminQnaDto.getComment());


		if(addminQnaDto.getComment()!=null || addminQnaDto.getContent()=="") {
			System.out.println("코멘트 null이아니다에옴");
			addminQnaDto.setAnswer(true);
		}else {
			addminQnaDto.setAnswer(false);
		}

			System.out.println("addminQnaDeo의 앤솔은 ? ="+addminQnaDto.isAnswer());
		AddminQnaRepository.qnaUpdate(addminQnaDto);
		System.out.println("업데이트는무사히마친듯");
		AddminQnaRepository.qnaRecommentSave(addminQnaDto);



		return "ok";
	}

//	@GetMapping("/qnaLecoment/{id}")
//	public String Qnarecomment2(@PathVariable int id) {
//		System.out.println("가져온 id22222222 === = "+id);
//		return "/addminQnaRecomment";
//	}
//
//


}
