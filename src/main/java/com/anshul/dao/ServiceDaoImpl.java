package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Services;

public class ServiceDaoImpl implements ServiceDao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Services> getServices(){
		List<Services> list;
		String sql="select * from services";
		list=(List<Services>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Services>(Services.class));
		return list;
	}

}
