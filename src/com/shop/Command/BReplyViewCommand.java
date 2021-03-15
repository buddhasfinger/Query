package com.shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Dao.BoardDao;
import com.shop.Dto.BoardDto;

public class BReplyViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		String bId=request.getParameter("bId");
		String page=request.getParameter("page");
		
		BoardDto dto= dao.bReplyView(bId);
		
		request.setAttribute("dto", dto);
		request.setAttribute("page", page);
	}

}
