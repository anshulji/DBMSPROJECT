package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Message;
import com.anshul.model.Product;

public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addMessage(Message message) {
		
			String sql="insert into anon_messages values(?,?,?,?)";
			Object[] object= {message.getName(),message.getEmail(),message.getSubject(),message.getMessage()};
			jdbcTemplate.update(sql,object);
		
	}
	
	

}
