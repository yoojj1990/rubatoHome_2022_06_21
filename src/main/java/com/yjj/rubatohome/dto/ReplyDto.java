package com.yjj.rubatohome.dto;

public class ReplyDto {
	
	private int rbnum; // 덧글 고유번호
	private int rborifbnum; // 덧글이 달린 게시판 번호
	protected String rbid; // 덧글쓴 아이디
	protected String rbcontent; // 덧글 내용
	protected String rbdate;  // 덧글쓴 날짜시간
	
	public int getRbnum() {
		return rbnum;
	}
	public void setRbnum(int rbnum) {
		this.rbnum = rbnum;
	}
	public int getRborifbnum() {
		return rborifbnum;
	}
	public void setRborifbnum(int rborifbnum) {
		this.rborifbnum = rborifbnum;
	}
	public String getRbid() {
		return rbid;
	}
	public void setRbid(String rbid) {
		this.rbid = rbid;
	}
	public String getRbcontent() {
		return rbcontent;
	}
	public void setRbcontent(String rbcontent) {
		this.rbcontent = rbcontent;
	}
	public String getRbdate() {
		return rbdate;
	}
	public void setRbdate(String rbdate) {
		this.rbdate = rbdate;
	}
	
	
	
	
}
