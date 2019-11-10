package com.anshul.dao;

import java.util.List;

import com.anshul.model.Appointment;
import com.anshul.model.AppointmentTable;
import com.anshul.model.Message;
import com.anshul.model.Product;

public interface AppointmentDao {
	public void addApp(Appointment appointment);

	public List<AppointmentTable> getAppointmentsByUsername(String name);
	

}
