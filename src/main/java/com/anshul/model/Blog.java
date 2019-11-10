package com.anshul.model;

import java.text.SimpleDateFormat;

public class Blog{
	private int blog_id;
	private String image;
	private String title;
	private String content;
	private java.util.Date date;

	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image=image;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content=content;
	}

	public java.util.Date getDate(){
		return date;
	}

	public void setDate(java.util.Date date){
		this.date=date;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	
	public String getDateString(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = format.format(date);
		
		return dateString;
	}
	
}
