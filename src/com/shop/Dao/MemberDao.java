package com.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.Dto.MemberDto;

public class MemberDao {
	
	DataSource ds=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<MemberDto> list= new ArrayList<MemberDto>();
	MemberDto dto= null;
	String id,pw,name,nName,eMail1,eMail2,tel,address1,address2,gender,hobby;
    Timestamp mDate;
	String query;
	
	public MemberDao() { //생성자
		try {
			Context context =new InitialContext();
			 ds= (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public MemberDto loginCheck(String user_id,String user_pw) {
		dto=null;//초기화
		try {
			conn=ds.getConnection();
			query="select * from member where id=? and pw=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				id=rs.getString("id");
				pw=rs.getString("pw");
				name=rs.getString("name");
				nName=rs.getString("nName");
				eMail1=rs.getString("eMail1");
				eMail2=rs.getString("eMail2");
				tel=rs.getString("tel");
				address1=rs.getString("address1");
				address2=rs.getString("address2");
				gender=rs.getString("gender");
				hobby=rs.getString("hobby");
				mDate=rs.getTimestamp("mdate");
				dto = new MemberDto(id,pw,name,nName,eMail1,eMail2,tel,address1,address2,gender,hobby,mDate);
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
	}
	
	
}//class
