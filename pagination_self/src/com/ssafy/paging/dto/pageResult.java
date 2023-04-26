package com.ssafy.paging.dto;

public class pageResult {
	private int pageNo; //현재 페이지 번호
	private int count; // 전체 데이터 개ㅜㅅ
	private int lastPage; // 마지막 페이지 번호
	private int beginPage; // 현재 탭의 시작페이지 번호
	private int endPage; // 현재 탭의 마지막 페이지 번호
	private boolean prevExists; // 이전 페이지 존재 여부
	private boolean nextExists; // 다음 페이지 존재 여부
	
	
	
	public pageResult(int pageNo, int count) {
		this(pageNo, count, 10, 10);
	}



	public pageResult(int pageNo, int count, int listSize, int tabSize) {
		this.pageNo = pageNo;
		this.count = count;
		
		lastPage = (int)Math.ceil((double)count / listSize);
		
		int curTab = (pageNo - 1)/tabSize + 1;
		
		beginPage = (curTab -1) * tabSize + 1;
		endPage = Math.min(curTab * tabSize, lastPage);
		prevExists = beginPage != 1;
		nextExists = endPage != lastPage;
		
	}
}
