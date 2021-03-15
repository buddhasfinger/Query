package com.shop.Dto;

import java.sql.Timestamp;

public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String nName;
	private String eMail1;
	private String eMail2;
	private String tel;
	private String address1;
	private String address2;
	private String gender;
	private String hobby;
	private Timestamp mDate;
	
	public MemberDto() {}
	public MemberDto(String id, String pw, String name, String nName, String eMail1, String eMail2, String tel,
			String address1, String address2, String gender, String hobby, Timestamp mDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nName = nName;
		this.eMail1 = eMail1;
		this.eMail2 = eMail2;
		this.tel = tel;
		this.address1 = address1;
		this.address2 = address2;
		this.gender = gender;
		this.hobby = hobby;
		this.mDate = mDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String geteMail1() {
		return eMail1;
	}
	public void seteMail1(String eMail1) {
		this.eMail1 = eMail1;
	}
	public String geteMail2() {
		return eMail2;
	}
	public void seteMail2(String eMail2) {
		this.eMail2 = eMail2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Timestamp getmDate() {
		return mDate;
	}
	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}
}
