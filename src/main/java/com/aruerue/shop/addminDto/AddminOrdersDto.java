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
public class AddminOrdersDto {
	private int id;
	private int userId;
	private Timestamp orderDate;
	private int totalPrice;
	private String username;
	private Timestamp createDate;
	private String address;
	private String detail_address;
	private String howToPay;

}
