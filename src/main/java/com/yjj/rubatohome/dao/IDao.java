package com.yjj.rubatohome.dao;

import java.util.ArrayList;

import com.yjj.rubatohome.dto.FBoardDto;

public interface IDao {

	// 자유 게시판용 Dao
	public void fbwriteDao(String fbname, String fbtitle, String fbcontent, String fbid); // 자유게시판 글쓰기
	public ArrayList<FBoardDto> fblistDao(); // 자유게시판 데이터 가져오기
	public int fblistcountDao(); // 자유게시판 글 수 
	public void fbhitDao(String fbnum); // 자유게시판 조회수 증가
	
	
	
	
	
	
	// member Dao
	
	
}
