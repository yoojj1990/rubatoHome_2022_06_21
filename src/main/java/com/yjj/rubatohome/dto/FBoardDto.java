package com.yjj.rubatohome.dto;

public class FBoardDto {

	private int fbnum; //게시판 글 번호
	private String fbname; // 게시판 글쓴이 이름
	private String fbtitle; // 게시판 글제목
	private String fbcontent; // 게시판 글내용
	private String fbid; // 게시판 글쓴이 아이디
	private String fbhit; // 조회수
	private String fbdate; // 게시판 글쓴 날짜
	private int fbreplycount; // 해당글 덧글 수

	public FBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FBoardDto(int fbnum, String fbname, String fbtitle, String fbcontent, String fbid, String fbhit,
			String fbdate, int fbreplycount) {
		super();
		this.fbnum = fbnum;
		this.fbname = fbname;
		this.fbtitle = fbtitle;
		this.fbcontent = fbcontent;
		this.fbid = fbid;
		this.fbhit = fbhit;
		this.fbdate = fbdate;
		this.fbreplycount = fbreplycount;
	}

	public int getFbnum() {
		return fbnum;
	}

	public void setFbnum(int fbnum) {
		this.fbnum = fbnum;
	}

	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}

	public String getFbtitle() {
		return fbtitle;
	}

	public void setFbtitle(String fbtitle) {
		this.fbtitle = fbtitle;
	}

	public String getFbcontent() {
		return fbcontent;
	}

	public void setFbcontent(String fbcontent) {
		this.fbcontent = fbcontent;
	}

	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	public String getFbhit() {
		return fbhit;
	}

	public void setFbhit(String fbhit) {
		this.fbhit = fbhit;
	}

	public String getFbdate() {
		return fbdate;
	}

	public void setFbdate(String fbdate) {
		this.fbdate = fbdate;
	}

	public int getFbreplycount() {
		return fbreplycount;
	}

	public void setFbreplycount(int fbreplycount) {
		this.fbreplycount = fbreplycount;
	}
	
	

	
	
}
