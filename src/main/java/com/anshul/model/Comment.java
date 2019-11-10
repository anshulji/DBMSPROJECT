package com.anshul.model;

import java.text.SimpleDateFormat;

public class Comment {
	
	private int comment_id;
	private int blog_id;
	private String comment;
	private java.util.Date date;
	private java.sql.Time time;
	private String username;
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public java.sql.Time getTime() {
		return time;
	}
	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public String getDateString(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = format.format(date);
		
		return dateString;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
