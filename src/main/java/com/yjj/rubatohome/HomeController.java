package com.yjj.rubatohome;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjj.rubatohome.dao.IDao;
import com.yjj.rubatohome.dto.FBoardDto;

@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@RequestMapping(value="/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/board_list")
	public String board_list(HttpServletRequest request, Model model) {
		
		String searchKeyword = request.getParameter("searchKeyword");
		String searchOption = request.getParameter("searchOption");
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		ArrayList<FBoardDto> fboardDtos = null;  // 초기값 반드시 넣기 
		
		if(searchOption == null || searchKeyword == null) {
			fboardDtos = dao.fblistDao();
		} else {
			if(searchOption.equals("title")) { // 제목에서 특정 키워드 검색한 결과
				fboardDtos = dao.fbTitleSearchlistDao(searchKeyword);
			} else if (searchOption.equals("content")) {  // 내용에서 특정 키워드 검색한 결과
				fboardDtos = dao.fbContentSearchlistDao(searchKeyword);
			} else if (searchOption.equals("writer")) {  // 글쓴이에서 특정 키워드 검색한 결과
				fboardDtos = dao.fbWriteSearchlistDao(searchKeyword);
			}
		}
		
		model.addAttribute("fblist", fboardDtos);
		model.addAttribute("listcount", fboardDtos.size());
		
		return "board_list";
	}
	
	@RequestMapping(value = "/board_view")
	public String board_view(HttpServletRequest request, Model model) {
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		String fbnum = request.getParameter("fbnum");
		dao.fbhitDao(fbnum); // 조회수 증가 함수
		
		model.addAttribute("fbview", dao.fbviewDao(fbnum));
		
		
		return "board_view";
	}
	
	@RequestMapping(value = "/board_write")
	public String board_write() {
		
		return "board_write";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", request.getParameter("mid"));
		
		model.addAttribute("memberId", request.getParameter("mid"));
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		
		return "logout";
	}
	
	@RequestMapping(value = "/fbWrite")
	public String fbWrite(HttpServletRequest request) {
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		String fbname = request.getParameter("fbname");
		String fbtitle = request.getParameter("fbtitle");
		String fbcontent = request.getParameter("fbcontent");
		
		HttpSession session = request.getSession(); // 세션에서 아이디 값 찾아서 넣기
		String fbid = (String)session.getAttribute("id");
		
		if (fbid == null) {
			fbid = "GUEST";
		}
		
		dao.fbwriteDao(fbname, fbtitle, fbcontent, fbid);
		
		
		return "redirect:board_list";
	}
	
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request) {
		
		String fbnum = request.getParameter("fbnum"); // 삭제할 게시판 글 번호 가져오기
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		dao.fbdeleteDao(fbnum);
		
		return "redirect:board_list";
	}
	
	
	
	
	

}
