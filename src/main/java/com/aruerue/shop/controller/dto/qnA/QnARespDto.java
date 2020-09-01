package com.aruerue.shop.controller.dto.qnA;

import java.sql.Timestamp;

import com.aruerue.shop.controller.dto.CommonRespDto.CommonRespDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//q.id, q.title, u.username, q.createDate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnARespDto {
private int id;
private String title;
private String username;
private Timestamp createDate;
}
