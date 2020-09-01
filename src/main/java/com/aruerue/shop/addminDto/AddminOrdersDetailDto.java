package com.aruerue.shop.addminDto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddminOrdersDetailDto {
private int id;
private int orders_detailId;
private Date orderDate;
private int totalPrice;
private String howToPay;
private int price;
private String stats;
private int fee;
private String title;
private String name;
private String address;
private String detail_address;
private int quantity;
private String type;


///여긴 categoryId 체인지하는곳

}
