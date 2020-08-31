package com.aruerue.shop.model.qnA;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentOnQnA {
private int id;
private int qnAId;
private String comment;
private Timestamp createDate;
}
