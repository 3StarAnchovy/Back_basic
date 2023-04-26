package com.ssafy.paging.model.service;

import java.util.Map;

import com.ssafy.paging.dto.Page;

public interface BoardService {
	Map<String, Object> listBoard(Page search) throws Exception;
}