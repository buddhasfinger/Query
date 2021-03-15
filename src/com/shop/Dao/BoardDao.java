package com.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.Dto.BoardDto;
import com.shop.Dto.MemberDto;

public class BoardDao {
	
	DataSource ds=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<BoardDto> list= new ArrayList<BoardDto>();
	BoardDto dto= null;
    int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent,fileName;
	Timestamp bDate;
	String query;
	int chk=0;
	public BoardDao() { //생성자
		try {
			Context context =new InitialContext();
			 ds= (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	//수정뷰페이지 메소드
	public BoardDto bModifyView(String user_id) {
		dto=null;
		
		try {
			conn=ds.getConnection();
			query="select * from notice_board where bId=?";
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bId=rs.getInt("bId");
				bHit= rs.getInt("bHit");
				bGroup= rs.getInt("bGroup");
				bStep= rs.getInt("bStep");
				bIndent= rs.getInt("bIndent");
				bName= rs.getString("bName");
				bTitle= rs.getString("bTitle");
				bContent= rs.getString("bContent");
				fileName= rs.getString("fileName");
				bDate=rs.getTimestamp("bDate");
				
				dto = new BoardDto(bId,bHit,bGroup,bStep,bIndent,bName,bTitle,bContent,fileName,bDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//bModifyView
	
	
	//해당글 부모이하 답글 1씩 증가 메소드
	public void replyPlus(String bGroup,String bStep) {
		
		try {
			conn=ds.getConnection();
			query="update notice_board set bStep=bStep+1 "
					+ "where bGroup=? and bStep >? ";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bGroup);		
			pstmt.setString(2,bStep);		
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//replyPlus
	
	
	//답글달기 메소드
	public int BReply(String bName,String bTitle,String bContent,String fileName,
			String bId,String bGroup,String bStep,String bIndent) {
		
		//해당글 부모이하 답글 1씩 증가 메소드
		replyPlus(bGroup,bStep);
		//조회수증가
		upHit(bId);
		try {
			conn=ds.getConnection();
			query="insert into notice_board values("
					+"board_seq.nextval,?,?,?,sysdate,0,?,?,?,?)";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bGroup); //부모와 그룹동일
			pstmt.setInt(5, Integer.parseInt(bStep)+1);// 부모보다 1크게
			pstmt.setInt(6, Integer.parseInt(bIndent)+1); //들여쓰기 1증가
			pstmt.setString(7, fileName);
					
			chk = pstmt.executeUpdate();		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}
	
	
	
	//답글달기 뷰페이지 메소드
	public BoardDto bReplyView(String user_id) {
		dto=null;
		try {
			conn=ds.getConnection();
			query="select * from notice_board where bId=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bId=rs.getInt("bId");
				bHit= rs.getInt("bHit");
				bGroup= rs.getInt("bGroup");
				bStep= rs.getInt("bStep");
				bIndent= rs.getInt("bIndent");
				bName= rs.getString("bName");
				bTitle= rs.getString("bTitle");
				bContent= rs.getString("bContent");
				fileName= rs.getString("fileName");
				bDate=rs.getTimestamp("bDate");
				
				dto = new BoardDto(bId,bHit,bGroup,bStep,bIndent,bName,bTitle,bContent,fileName,bDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//bReplyView
	
	
	public int bDelete(String user_id){
		chk=1;
		
		try {
			conn=ds.getConnection();
			query="delete notice_board where bId=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			chk= pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}//bDelete
	
	//조회수 증가
	public void upHit(String user_id) {
		
		try {
			conn = ds.getConnection();
			query= "update notice_board set bHit=bHit+1 where bId=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//upHit
	
	
	//content 뷰페이지 메소드호출
	public BoardDto bContentView(String user_id) {
		
		//조회수 증가
		upHit(user_id);
		
		dto= null;
		try {
			conn = ds.getConnection();
			query= "select * from notice_board where bId=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bId= rs.getInt("bId");
				bHit= rs.getInt("bHit");
				bGroup= rs.getInt("bGroup");
				bStep= rs.getInt("bStep");
				bIndent= rs.getInt("bIndent");
				bName= rs.getString("bName");
				bTitle= rs.getString("bTitle");
				bContent= rs.getString("bContent");
				fileName= rs.getString("fileName");
				bDate=rs.getTimestamp("bDate");
				
				dto = new BoardDto(bId,bHit,bGroup,bStep,bIndent,bName,bTitle,bContent,fileName,bDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//bContentView
	
	
	
	//글쓰기 메소드
	public int BWrite(String bName,String bTitle,String bContent,String fileName) {
		try {
			conn=ds.getConnection();
			query="insert into notice_board values("
					+ "board_seq.nextval,?,?,?,sysdate,"
					+ "0,board_seq.currval,0,0,?)";
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, fileName);
			chk= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}
	
	
	
	//전체게시글 count
	public int listCount() {
		int count=0;
		try {
			conn=ds.getConnection();
			query="select count(*) as count from notice_board";
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			System.out.println("rs받아짐?"+rs);
			if(rs.next()) {
				count=rs.getInt("count");
				System.out.println("count"+count);
				//count=rs.getInt(1); as count를 안쓰면 그냥 1을 넣으면 count(*)값이 담긴다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	
	
	//전체게시글 list
	public ArrayList<BoardDto> list(int page,int limit) {
		list=new ArrayList<BoardDto>();//초기화
		int startrow = (page-1)*limit+1; //시작 게시글번호 1,11,21...
		int endrow = startrow+limit-1;//마지막 게시글 번호 10,20,30...
		try {
			conn=ds.getConnection();
			query="select * from"
					+ "(select rownum rnum, a.* from "
					+ "(select * from notice_board order by bGroup desc, bStep asc) a)"
					+ "where rnum >=? and rnum <=?";
			
			//query="select * from notice_board order by bGroup desc,bStep asc";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bId=rs.getInt("bId");
				bHit=rs.getInt("bHit");
				bGroup=rs.getInt("bGroup");
				bStep=rs.getInt("bStep");
				bIndent=rs.getInt("bIndent");
				bName=rs.getString("bName");
				bTitle=rs.getString("bTitle");
				bContent=rs.getString("bContent");
				fileName=rs.getString("fileName");
				bDate=rs.getTimestamp("bDate");
				list.add(new BoardDto(bId,bHit,bGroup,bStep,bIndent,bName,bTitle,bContent,fileName,bDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//list
	
	
}//class
