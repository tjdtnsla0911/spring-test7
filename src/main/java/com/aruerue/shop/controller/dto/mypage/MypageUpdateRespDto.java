package com.aruerue.shop.controller.dto.mypage;

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//회원수정 페이지에 미리 뿌려져있어야 하는 값들.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MypageUpdateRespDto {
	private String profile;
	private String email;
	private String name;
	private String gender;
	private String phone;
	private String address;
	private String detail_address;
	private Timestamp birthday;
	

}
