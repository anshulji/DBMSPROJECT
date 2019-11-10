package com.anshul.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.anshul.model.Customer;
import com.anshul.model.User;

public interface Userdao{
	@Autowired
	public void saveOrUpdate(Customer user);
	public void delete(String username);
	public Customer getUser(String username);
}