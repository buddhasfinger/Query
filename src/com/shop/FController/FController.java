package com.shop.FController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Command.BContentViewCommand;
import com.shop.Command.BDeleteCommand;
import com.shop.Command.BListCommand;
import com.shop.Command.BModifyCommand;
import com.shop.Command.BModifyViewCommand;
import com.shop.Command.BReplyCommand;
import com.shop.Command.BReplyViewCommand;
import com.shop.Command.BWriteCommand;
import com.shop.Command.Command;
import com.shop.Command.LoginCommand;

@WebServlet("*.do")
public class FController extends HttpServlet {
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String requestUri = request.getRequestURI(); // contextPath/login.do
		String contextPath = request.getContextPath();
		String com = requestUri.substring(contextPath.length());
		Command command=null;
		String viewPage=null;
		boolean pageRedirect= false;
		
		if(com.equals("/login.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage="login_check.jsp";
		}else if(com.equals("/list.do")) {
			System.out.println("page:"+request.getParameter("page"));
			command = new BListCommand();
			command.execute(request, response);
			viewPage="list.jsp";
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage="write_check.jsp";
			//pageRedirect=true; 이렇게 하면 BwriteCommand flag chk에 담은걸 싹 지우고 새로 보내라 그래서 write_check의 if문이 안돈다.
			
		}else if(com.equals("/write_view.do")) {
			viewPage="write_view.jsp";
		}else if(com.equals("/content_view.do")) {
			command= new BContentViewCommand();
			command.execute(request, response);
			viewPage="content_view.jsp";
		}else if(com.equals("/delete.do")) {
			command= new BDeleteCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/bReplyView.do")) {
			command= new BReplyViewCommand();
			command.execute(request, response);
			viewPage="reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			command= new BReplyCommand();
			command.execute(request, response);
			viewPage="list.do";
			pageRedirect=true;
		}else if(com.equals("/bModify_view.do")) {
			command= new BModifyViewCommand();
			command.execute(request, response);
			viewPage="modify_view.jsp";
			pageRedirect=true;
		}else if(com.equals("/modify.do")) {
			command= new BModifyCommand();
			command.execute(request, response);
			viewPage="content_view.do";
		}
		
		if(pageRedirect==true) {
			response.sendRedirect(viewPage);
		}else {
			RequestDispatcher patcher= request.getRequestDispatcher(viewPage);
			patcher.forward(request, response);
			//주소이동하는 방법 2가지 - sendRedirect, forward- 포워드는jsp에만 있다. 그래서 서블렛에서 포워드를 쓰고 싶으면 requestDispatcher로 보내야한다
			// forward는 샌드리다이렉트와 다르게 request와 response를 새로 추가해서 보낸다.
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

}
