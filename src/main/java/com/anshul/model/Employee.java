package com.anshul.model;

import java.text.SimpleDateFormat;

public class Employee{
	private String emp_name;
	private String emp_gender;
	private String emp_email;
	private String emp_houseno;
	private String emp_colony;
	private String emp_city;
	private String emp_state;
	private int emp_pincode;
	private java.util.Date emp_doj;
	private int emp_salary;
	private String emp_aadhar;
	private java.util.Date emp_dob;
	private int user_id;
	private int emp_age;
	
	public String getDoj(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = format.format(emp_doj);
		
		return dateString;
	}
	
	public String getDob(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = format.format(emp_dob);
		
		return dateString;
	}

	public String getEmp_name(){
		return emp_name;
	}

	public void setEmp_name(String emp_name){
		this.emp_name=emp_name;
	}

	public String getEmp_gender(){
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender){
		this.emp_gender=emp_gender;
	}

	public String getEmp_email(){
		return emp_email;
	}

	public void setEmp_email(String emp_email){
		this.emp_email=emp_email;
	}

	public String getEmp_houseno(){
		return emp_houseno;
	}

	public void setEmp_houseno(String emp_houseno){
		this.emp_houseno=emp_houseno;
	}

	public String getEmp_colony(){
		return emp_colony;
	}

	public void setEmp_colony(String emp_colony){
		this.emp_colony=emp_colony;
	}

	public String getEmp_city(){
		return emp_city;
	}

	public void setEmp_city(String emp_city){
		this.emp_city=emp_city;
	}

	public String getEmp_state(){
		return emp_state;
	}

	public void setEmp_state(String emp_state){
		this.emp_state=emp_state;
	}

	public int getEmp_pincode(){
		return emp_pincode;
	}

	public void setEmp_pincode(int emp_pincode){
		this.emp_pincode=emp_pincode;
	}

	public java.util.Date getEmp_doj(){
		return emp_doj;
	}

	public void setEmp_doj(java.util.Date emp_doj){
		this.emp_doj=emp_doj;
	}

	public int getEmp_salary(){
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary){
		this.emp_salary=emp_salary;
	}

	public String getEmp_aadhar(){
		return emp_aadhar;
	}

	public void setEmp_aadhar(String emp_aadhar){
		this.emp_aadhar=emp_aadhar;
	}

	public java.util.Date getEmp_dob(){
		return emp_dob;
	}

	public void setEmp_dob(java.util.Date emp_dob){
		this.emp_dob=emp_dob;
	}

	public int getUser_id(){
		return user_id;
	}

	public void setUser_id(int user_id){
		this.user_id=user_id;
	}

	public int getEmp_age(){
		return emp_age;
	}

	public void setEmp_age(int emp_age){
		this.emp_age=emp_age;
	}
}
