package com.aruerue.shop.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
private int id;
private String title;
private String thumb;
private int price;
private String disc;
private boolean ad;
private int discounted;
private String content;
private int categoryId;
private String bgImg;

/////////////////////////
private String changebgImg;
private boolean sale;
private boolean newly;
private boolean best;


/////////////////////////boolean 교체문


private String sale2;
private String newly2;
private String best2;
private String categoryId2;

}
