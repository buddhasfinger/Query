package com.shop.Command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.Dao.BoardDao;

public class BWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao= new BoardDao();
		int chk=0; // 성공,실패 체크변수
		//파일업로드 관련변수 
		String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		int size = 10* 1024*1024; //10M byte
		String bName ="",bTitle="",bContent="", fileName="";
		try {
			MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
			bName= multi.getParameter("bName");
			bTitle=multi.getParameter("bTitle");
			bContent=multi.getParameter("bContent");
			fileName = multi.getFilesystemName("fileName");
			
			chk = dao.BWrite(bName,bTitle,bContent,fileName);
			//chk=-1;
			System.out.println("chk :"+chk);
			request.setAttribute("flag", chk);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
