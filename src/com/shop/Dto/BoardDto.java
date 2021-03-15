package com.shop.Dto;

import java.sql.Timestamp;

public class BoardDto {
	
	private int bId,bHit,bGroup,bStep,bIndent;
	private String bName,bTitle,bContent,fileName;
	private Timestamp bDate;
	
	public BoardDto() {}
	public BoardDto(int bId, int bHit, int bGroup, int bStep, int bIndent, String bName, String bTitle, String bContent,
			String fileName, Timestamp bDate) {
		this.bId = bId;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.fileName = fileName;
		this.bDate = bDate;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	
	
	
}
