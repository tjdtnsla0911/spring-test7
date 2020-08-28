package com.aruerue.shop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonRespDto<T> {
	private int statusCode; //1정상,  -1실패, 0 변경 안됨 원래는 enum 써야한다.
	private T data;
	//이걸 new할때마다 동적으로 오브젝트를 넣어주면 됨 ->제네릭 오브젝트를 활용하는것이다.

}

