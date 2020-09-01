package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.addminDto.AddminOrdersDetailDto;
import com.aruerue.shop.addminDto.AddminOrdersDto;

public interface AddminOrdersRepository {
	List<AddminOrdersDto> findAllOrderList();
	List<AddminOrdersDetailDto> findAllOrderDetailList();
	List<AddminOrdersDetailDto> findAllOrderDetailList2(int id);
	public void updateOrders(AddminOrdersDetailDto add);

}
