package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Appointment;
import com.anshul.model.AppointmentTable;
import com.anshul.model.Customer;
import com.anshul.model.Employee;
import com.anshul.model.Message;
import com.anshul.model.Prod_bill;
import com.anshul.model.Prod_bill_items;
import com.anshul.model.Product;
import com.anshul.model.Services;
import com.anshul.model.WishlistDemand;

public class AdmindaoImpl implements Admindao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addEmployee(Employee employee) {
		 String sql = "INSERT INTO employee(emp_name,emp_gender,emp_email,emp_houseno,emp_colony,emp_city,emp_state,emp_pincode,emp_doj,emp_salary,emp_aadhar,emp_dob,emp_age) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {employee.getEmp_name(),employee.getEmp_gender(),employee.getEmp_email(),employee.getEmp_houseno(),employee.getEmp_colony(),employee.getEmp_city(),employee.getEmp_state(),employee.getEmp_pincode(),employee.getEmp_doj(), employee.getEmp_salary(),employee.getEmp_aadhar(),employee.getEmp_dob(),employee.getEmp_age()});
		 
	}

	public List<Employee> getallemp() {
		List<Employee> list;
		String sql="select * from employee";
		list=(List<Employee>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}

	public List<WishlistDemand> getWishlistDemand() {
		List<WishlistDemand> list;
		String sql="select count(*) as prod_count,product.prod_name from wishlist,product where wishlist.prod_id=product.prod_id group by product.prod_name" ;
		list=(List<WishlistDemand>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<WishlistDemand>(WishlistDemand.class));
		return list;
	}

	public List<Message> getmessages() {
		List<Message> list;
		String sql="select * from anon_messages" ;
		list=(List<Message>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Message>(Message.class));
		return list;
	}

	public List<AppointmentTable> getApp() {
		List<AppointmentTable> list;
		String sql="select app_id,username,date,start_time,home_or_shop,status_name,amount,emp_id from appointment,app_status where appointment.status_id=app_status.status_id";
		list=(List<AppointmentTable>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<AppointmentTable>(AppointmentTable.class));
		return list;
	}

	public Appointment getAppbyid(int app_id) {
		List<Appointment> list;
		String sql="select * from appointment where appointment.app_id=\""+app_id+"\"";
		list=(List<Appointment>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Appointment>(Appointment.class));
		return list.get(0);
	}

	public void updateapp(Appointment app) {
		System.out.print(app.getApp_id()+","+app.getStatus_id()+"hehe");
		String sql="update appointment set status_id=\""+app.getStatus_id()+"\" , amount=\""+app.getAmount()+"\" where app_id=\""+app.getApp_id()+"\"";
		jdbcTemplate.update(sql);
	}

	public List<Services> getallserv() {
		List<Services> list;
		String sql="select * from services" ;
		list=(List<Services>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Services>(Services.class));
		return list;
	}

	public void addService(Services service) {
		String sql="insert into services(service_name,price,description,image) values(?,?,?,?)";
		Object[] object= {service.getService_name(),service.getPrice(),service.getDescription(),"noimage"};
		jdbcTemplate.update(sql,object);		
	}

	public void addProd_bill(Prod_bill prod_bill) {
		String sql="insert into prod_bill(date,amount,username) values(?,?,?)";
		Object[] object= {prod_bill.getDate(),prod_bill.getAmount(),prod_bill.getUsername()};
		jdbcTemplate.update(sql,object);	
	}

	public Prod_bill getlatestprodid() {
		List<Prod_bill> list;

		String sql="select * from prod_bill order by pbill_id desc limit 1" ;
		list=(List<Prod_bill>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Prod_bill>(Prod_bill.class));
		return list.get(0);
	}

	public void addProd_bill_items(Prod_bill_items prod_bill_items) {
		String sql="insert into prod_bill_items values(?,?,?)";
		Object[] object= {prod_bill_items.getProd_id(),prod_bill_items.getQuantity(),prod_bill_items.getPbill_id()};
		jdbcTemplate.update(sql,object);
		
		List<Product> list;

		sql="select * from product where prod_id=\""+prod_bill_items.getProd_id()+"\"" ;
		list=(List<Product>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		int amnt = list.get(0).getProd_price()*prod_bill_items.getQuantity();
		
		sql="select * from prod_bill order by pbill_id desc limit 1" ;
		List<Prod_bill> list1=(List<Prod_bill>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Prod_bill>(Prod_bill.class));
		 System.out.print("hehe"+amnt+","+list1.get(0).getPbill_id());
		sql="update prod_bill set amount=amount+\""+amnt+"\" where pbill_id=\""+list1.get(0).getPbill_id()+"\"";
		jdbcTemplate.update(sql);
		
		
	}

	public List<Prod_bill_items> getProditemsbyid(int pbill_id) {
		List<Prod_bill_items> list;

		String sql="select * from prod_bill_items where pbill_id=\""+pbill_id+"\"" ;
		list=(List<Prod_bill_items>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Prod_bill_items>(Prod_bill_items.class));
		return list;
	}

}
