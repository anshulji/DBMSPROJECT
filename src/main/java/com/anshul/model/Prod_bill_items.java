package com.anshul.model;

public class Prod_bill_items{
	private int pbill_id;
	private int prod_id;
	private int quantity;
	private int price;


	public int getProd_id(){
		return prod_id;
	}

	public void setProd_id(int prod_id){
		this.prod_id=prod_id;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setQuantity(int quantity){
		this.quantity=quantity;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public int getPbill_id() {
		return pbill_id;
	}

	public void setPbill_id(int pbill_id) {
		this.pbill_id = pbill_id;
	}
}
