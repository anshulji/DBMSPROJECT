package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Prod_category;
import com.anshul.model.Services;

public class ProdCatDaoImpl implements ProdCatDao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Prod_category> getProdCat(){
		List<Prod_category> list;
		String sql="select * from prod_category";
		list=(List<Prod_category>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Prod_category>(Prod_category.class));
		return list;
	}

}
