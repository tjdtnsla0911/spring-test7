package com.aruerue.shop.model.user;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
private int id;
private int userId;
private Timestamp orderDate;
private int totalPrice;
private String howToPay;
}
