package com.yjj.rubatohome.dao;

import java.util.ArrayList;

import com.yjj.rubatohome.dto.FBoardDto;
import com.yjj.rubatohome.dto.FileDto;
import com.yjj.rubatohome.dto.ReplyDto;

public interface IDao {

	// 자유 게시판용 Dao
	public void fbwriteDao(String fbname, String fbtitle, String fbcontent, String fbid); // 자유게시판 글쓰기
	public ArrayList<FBoardDto> fblistDao(); // 자유게시판 데이터 가져오기
	public int fblistcountDao(); // 자유게시판 글 수 
	public void fbhitDao(String fbnum); // 자유게시판 조회수 증가
	public FBoardDto fbviewDao(String fbnum); // 자유게시판 글 보기
	
	public ArrayList<FBoardDto> fbTitleSearchlistDao(String keyeord); // 자유게시판 제목에서 검색한 결과 가져오기
	public ArrayList<FBoardDto> fbContentSearchlistDao(String keyeord); // 자유게시판 제목에서 검색한 결과 가져오기
	public ArrayList<FBoardDto> fbWriteSearchlistDao(String keyeord); // 자유게시판 제목에서 검색한 결과 가져오기
	
	public void fbdeleteDao(String fbnum); // 자유게시판 글 삭제
	
	public void fbfileInsertDao(int bno, String fileName, String fileOriName, String fileUrl, String fileExtemsion); 
	// 파일 원본이름, 변경된이름, 파일이 첨부된 게시글 번호, 파일경로를 DB에 저장
	public FileDto fbfileInfoDao(String bno); // 게시들 번호로 검색하여 해당 게시글에 첨부된 파일의 모든정보 불러오기
	
	
	// member Dao
	
	public void memberjoinDao(String mid, String mpw, String mname, String memail); // 회원가입 메서드
	public int checkIdDao(String mid);//회원 아이디 존재 여부 확인
	public int checkIdPwDao(String mid, String mpw);//로그인 시 회원 아이디와 비번 일치여부 체크
	
	
	//reply Dao
	
	public void rbwrite(int rborifbnum, String rbid, String rbcontent);
	public ArrayList<ReplyDto> rblist(String fbnum); // 덧글이 달린 원글의 게시판 번호를 인수로 호출
	
	
}
