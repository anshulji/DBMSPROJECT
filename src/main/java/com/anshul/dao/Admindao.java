package com.anshul.dao;

import java.util.List;

import com.anshul.model.Appointment;
import com.anshul.model.AppointmentTable;
import com.anshul.model.Employee;
import com.anshul.model.Message;
import com.anshul.model.Prod_bill;
import com.anshul.model.Prod_bill_items;
import com.anshul.model.Services;
import com.anshul.model.WishlistDemand;

public interface Admindao {
	
	public void addEmployee(Employee employee);

	public List<Employee> getallemp();

	public List<WishlistDemand> getWishlistDemand();
	
	public List<Message> getmessages();

	public List<AppointmentTable> getApp();

	public Appointment getAppbyid(int app_id);

	public void updateapp(Appointment app);

	public List<Services> getallserv();

	public void addService(Services service);

	public void addProd_bill(Prod_bill prod_bill);

	public Prod_bill getlatestprodid();

	public void addProd_bill_items(Prod_bill_items prod_bill_items);

	public List<Prod_bill_items> getProditemsbyid(int pbill_id);
}
