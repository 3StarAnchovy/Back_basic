package com.ssafy.paging.dto;

public class Page {
	private int pageNo; //현재 페이지 번호
	private int listSize; //한 페이지에 출력할 데이터 개수
	
	public Page() {
		this(1, 10); //1페이지에 10개
	}
	public Page(int pageNo) { 
		this(pageNo, 10);
	}
	public Page(int pageNo, int listSize) { 
		this.pageNo = pageNo; 
		this.listSize = listSize; 
	}

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
}