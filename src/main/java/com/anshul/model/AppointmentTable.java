package com.anshul.model;

import java.text.SimpleDateFormat;

public class AppointmentTable{
	private int app_id;
	private String username;
	private java.util.Date date;
	private java.sql.Time start_time;
	private String home_or_shop;
	private String status_name;
	private int amount;
	private int emp_id;
	
	public String getDateString(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = format.format(date);
		
		return dateString;
	}
	
	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public java.sql.Time getStart_time() {
		return start_time;
	}

	public void setStart_time(java.sql.Time start_time) {
		this.start_time = start_time;
	}


	public java.util.Date getDate(){
		return date;
	}

	public void setDate(java.util.Date date){
		this.date=date;
	}

	public String getHome_or_shop(){
		return home_or_shop;
	}

	public void setHome_or_shop(String home_or_shop){
		this.home_or_shop=home_or_shop;
	}


	public int getAmount(){
		return amount;
	}

	public void setAmount(int amount){
		this.amount=amount;
	}

	public int getEmp_id(){
		return emp_id;
	}

	public void setEmp_id(int emp_id){
		this.emp_id=emp_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
}
