package com.ssafy.model;

public class Board {
	private int num;
	private String title;
	private String content;
	private String writername;
	
	public Board() {
		super();
	}

	public Board(int num, String title, String content, String writername) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writername = writername;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritername() {
		return writername;
	}

	public void setWritername(String writername) {
		this.writername = writername;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", writername=" + writername + "]";
	}
	
	
	
}
