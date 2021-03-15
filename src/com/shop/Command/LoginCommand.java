package com.shop.Command;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Dao.MemberDao;
import com.shop.Dto.MemberDto;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//form에서 넘어온 id,pw
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		MemberDao dao= new MemberDao();
		MemberDto dto= dao.loginCheck(id,pw);
		
		//로그인 체크 후 session 추가
		HttpSession session= request.getSession();
		if(dto==null) {
			session.setAttribute("session_flag", "fail");
		}else {
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", dto.getId());
			session.setAttribute("session_nName", dto.getnName());
		}
		
	}

}
