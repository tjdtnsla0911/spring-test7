package com.aruerue.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QnaRecomment {
private int id;
private int qnaId;
private String qnaComment;
}
