package com.shop.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Dao.BoardDao;
import com.shop.Dto.BoardDto;

public class BListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao= new BoardDao();
		int page=1; //첫페이지 초기화
		int limit=10; //한 페이지에 표시되는 게시글 개수
		
		//page 데이터가 있으면 데이터값 적용
		if(request.getParameter("page")!=null && request.getParameter("page")!=("")) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
//		request.getParameter(null); //데이터가 넘어올 때 - form,파라미터값으로 전달된것
//		request.setAttribute(null, dao);  //서버 종료 될때까지 유지
//		request.getAttribute(null);
//		session.setAttribute("null",null); //세션이 끝날때까지 유지 30분.
//		session.getAttribute("null");
//		session.t${sessionScope.id};
		
		
		//게시글
		ArrayList<BoardDto> list = dao.list(page,limit);
		//전체리스트 개수메소드
		int listCount= dao.listCount();		
		//최대 페이지 수
		int maxpage= (int)((double)listCount/limit+0.95);
		//매 선택된 페이지 마다 제일 앞에 시작할 첫 페이지 번호 ex 35page = 30page
		int startpage = ((int)((double)page/10+0.9)-1) * 10+1;
		//마지막 페이지 번호
		int endpage= maxpage;
		if(endpage>startpage+10-1) endpage = startpage+10-1;
		//전송
		request.setAttribute("listCount", listCount);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
	}

}
