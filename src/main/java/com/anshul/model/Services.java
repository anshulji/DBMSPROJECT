package com.anshul.model;

public class Services{
	private String service_name;
	private int price;
	private String description;
	private String image;

	public String getService_name(){
		return service_name;
	}

	public void setService_name(String service_name){
		this.service_name=service_name;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image=image;
	}
}
