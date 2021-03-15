package com.shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Dao.BoardDao;

public class BDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		String bId= request.getParameter("bId");
		String page=request.getParameter("page");
		int chk = dao.bDelete(bId);
		
		request.setAttribute("page", page);
		request.setAttribute("chk", chk);
		
	}

}
