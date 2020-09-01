package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.addminDto.AddminQnaDto;
import com.aruerue.shop.model.qnA.Qna;

public interface AddminQnaRepository {
	List<AddminQnaDto> qnaList();
	public int qnaDelete(int id); 
	public void qnaUpdate(AddminQnaDto addminQnaDto);
	public void qnaRecommentSave(AddminQnaDto addminQnaDto);
	List<AddminQnaDto> selectQnaComment(AddminQnaDto addminQnaDto);

}
