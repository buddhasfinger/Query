package com.shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.Dao.BoardDao;

public class BReplyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		int chk=0; // 성공,실패 체크변수
		//파일업로드 관련변수 
		String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		int size = 10* 1024*1024; //10M byte
		String bName,bTitle,bContent,fileName="";
		String bId,bGroup,bStep,bIndent = "";
		try {
			MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
			bName= multi.getParameter("bName");
			bTitle=multi.getParameter("bTitle");
			bContent=multi.getParameter("bContent");
			fileName = multi.getFilesystemName("fileName");
			bId = multi.getParameter("bId");
			bGroup = multi.getParameter("bGroup");
			bStep = multi.getParameter("bStep");
			bIndent = multi.getParameter("bIndent");
			
			chk = dao.BReply(bName,bTitle,bContent,fileName,bId,bGroup,bStep,bIndent);
			
			System.out.println("chk :"+chk);
			request.setAttribute("flag", chk);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
