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
	public String board_list(Model model) {
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		ArrayList<FBoardDto> fboardDtos = dao.fblistDao();
		
		int listcount = dao.fblistcountDao();
		
		model.addAttribute("fblist", fboardDtos);
		model.addAttribute("listcount", listcount);
		
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

}
