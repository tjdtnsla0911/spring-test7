package com.aruerue.shop.controller.dto.mypage;

import java.sql.Timestamp;

//회원수정 페이지에 미리 뿌려져있어야 하는 값들.
public class MypageUpdateResponseDto {
	private String profile;
	private String email;
	private String name;
	private String gender;
	private String phone;
	private String address;
	private String detail_address;
	private Timestamp birthday;
	

}
