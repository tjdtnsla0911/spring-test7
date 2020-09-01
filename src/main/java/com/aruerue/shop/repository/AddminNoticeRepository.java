package com.aruerue.shop.repository;

import java.util.List;

import com.aruerue.shop.model.Notice;

public interface AddminNoticeRepository {
	List<Notice> findAllNotice();

}
