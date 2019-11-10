package com.anshul.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.anshul.model.Customer;
import com.anshul.model.User;

public class UserdaoImpl implements Userdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserdaoImpl() {
		
	}
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public void saveOrUpdate(Customer user) {
		 String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getCust_fname(),user.getCust_mname(),user.getCust_lname(),user.getCust_gender(),user.getCust_email(),user.getCust_houseno(),user.getCust_colony(),user.getCust_city(),user.getCust_state(),user.getCust_pincode(),user.getCust_dor(),user.getUsername(),user.getPassword(),1,user.getCust_contact()});
		 sql = "INSERT INTO users_roles(user,role) VALUES(?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),"ROLE_USER"});
		 
		 //System.out.println("EROOR");
	}
	public void delete(String username) {
		String sql = "DELETE FROM users WHERE username=?";
		jdbcTemplate.update(sql,username);
	}
	public Customer getUser(String username) {
		String sql = "SELECT * FROM customer WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Customer>() {
		
		public Customer extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Customer user = new Customer();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		}
		
	});
}
}