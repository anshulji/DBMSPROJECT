package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Prod_category;
import com.anshul.model.Product;
import com.anshul.model.Services;

public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> getprodbycat(int catid){
		List<Product> list;
		String sql="select * from product where cat_id=\""+catid+"\"";
		list=(List<Product>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return list;
	}

}
