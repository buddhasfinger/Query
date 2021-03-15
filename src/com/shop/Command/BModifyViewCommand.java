package com.shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Dao.BoardDao;
import com.shop.Dto.BoardDto;

public class BModifyViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao= new BoardDao();
		String page=request.getParameter("page");
		String bId=request.getParameter("bId");
		
		BoardDto dto = dao.bModifyView(bId);
		
		request.setAttribute("dto", dto);
		request.setAttribute("page", page);
		
	}

}
