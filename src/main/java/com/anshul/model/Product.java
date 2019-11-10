package com.anshul.model;

public class Product{
	private int prod_id;
	private int prod_price;
	private String prod_name;
	private String prod_desc;
	private String prod_image;
	private int quantity_available;
	private int cat_id;

	public int getProd_price(){
		return prod_price;
	}

	public void setProd_price(int prod_price){
		this.prod_price=prod_price;
	}

	public String getProd_name(){
		return prod_name;
	}

	public void setProd_name(String prod_name){
		this.prod_name=prod_name;
	}

	public String getProd_desc(){
		return prod_desc;
	}

	public void setProd_desc(String prod_desc){
		this.prod_desc=prod_desc;
	}

	public String getProd_image(){
		return prod_image;
	}

	public void setProd_image(String prod_image){
		this.prod_image=prod_image;
	}

	public int getQuantity_available(){
		return quantity_available;
	}

	public void setQuantity_available(int quantity_available){
		this.quantity_available=quantity_available;
	}

	public int getCat_id(){
		return cat_id;
	}

	public void setCat_id(int cat_id){
		this.cat_id=cat_id;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
}
