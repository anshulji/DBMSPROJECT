package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Appointment;
import com.anshul.model.AppointmentTable;
import com.anshul.model.Blog;

import com.anshul.model.Message;
import com.anshul.model.Product;

public class AppointmentDaoImpl implements AppointmentDao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addApp(Appointment appointment) {
		String sql="insert into appointment(date,start_time,home_or_shop,status_id,amount,emp_id,username) values(?,?,?,?,?,?,?)";
		Object[] object= {appointment.getDate(),appointment.getStart_time(),appointment.getHome_or_shop(),appointment.getStatus_id(),appointment.getAmount(),appointment.getEmp_id(),appointment.getUsername()};
		jdbcTemplate.update(sql,object);
	}

	public List<AppointmentTable> getAppointmentsByUsername(String name) {
		List<AppointmentTable> list;
		String sql="select app_id,username,date,start_time,home_or_shop,status_name,amount,emp_id from appointment,app_status where username=\""+name+"\" and appointment.status_id=app_status.status_id";
		list=(List<AppointmentTable>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<AppointmentTable>(AppointmentTable.class));
		return list;
	}
	public List<Blog> getBlogs(){
		List<Blog> list;
		String sql="select * from blog";
		list=(List<Blog>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
		return list;
	}
	
	

}
