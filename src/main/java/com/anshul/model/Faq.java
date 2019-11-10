package com.anshul.model;

public class Faq{
	private String is_answered;
	private String answer;
	private int cust_id;

	public String getIs_answered(){
		return is_answered;
	}

	public void setIs_answered(String is_answered){
		this.is_answered=is_answered;
	}

	public String getAnswer(){
		return answer;
	}

	public void setAnswer(String answer){
		this.answer=answer;
	}

	public int getCust_id(){
		return cust_id;
	}

	public void setCust_id(int cust_id){
		this.cust_id=cust_id;
	}
}
