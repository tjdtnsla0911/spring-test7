package com.aruerue.shop.addminDto;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddminQnaDto {
	private int id;
	private String qnaTitle;
	private String content;
	private String username;
	private String title;
	private Timestamp CreateDate;
	private boolean answer;
	private int productId;
	private int userId;
	private String comment;


	//////////////////////////////////



	//여긴 answer  true/false로 답변함

	private String answer2;




}
