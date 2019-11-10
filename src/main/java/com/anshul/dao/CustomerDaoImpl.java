package com.anshul.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.anshul.model.Blog;
import com.anshul.model.Customer;
import com.anshul.model.User;

public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Customer> getallcust() {
		List<Customer> list;
		String sql="select * from customer";
		list=(List<Customer>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
		return list;
	}
	
}