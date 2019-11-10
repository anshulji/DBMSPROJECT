package com.anshul.model;

public class Gallery{
	private java.util.Date date;
	private String description;
	private String image_url;

	public java.util.Date getDate(){
		return date;
	}

	public void setDate(java.util.Date date){
		this.date=date;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public String getImage_url(){
		return image_url;
	}

	public void setImage_url(String image_url){
		this.image_url=image_url;
	}
}
