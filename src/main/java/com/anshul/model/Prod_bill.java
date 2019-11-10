package com.anshul.model;

public class Prod_bill{
	private int pbill_id;
	private java.util.Date date;
	private int amount;
	private String username;

	public java.util.Date getDate(){
		return date;
	}

	public void setDate(java.util.Date date){
		this.date=date;
	}

	public int getAmount(){
		return amount;
	}

	public void setAmount(int amount){
		this.amount=amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPbill_id() {
		return pbill_id;
	}

	public void setPbill_id(int pbill_id) {
		this.pbill_id = pbill_id;
	}

	
}
