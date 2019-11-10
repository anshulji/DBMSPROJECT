package com.anshul;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anshul.dao.Admindao;
import com.anshul.dao.CustomerDao;
import com.anshul.model.Category;
import com.anshul.model.Customer;
import com.anshul.model.Employee;

import com.anshul.model.User;

@Controller
public class CategoryController {
	
	@Autowired
	CustomerDao customerDao;
	@Autowired
	Admindao adminDao;
	
	@RequestMapping(value="admin/addemployee",method=RequestMethod.GET)
	public String addemployee(Model model)
	{
		model.addAttribute("employee",new Employee());
		return "admin/addemployee";
	}
	
	@RequestMapping(value="admin/addemployee",method=RequestMethod.POST)
	public String addemppost(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model) 
	{
		adminDao.addEmployee(employee);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="admin/allemployee")
	public String allemp(Model model)
	{
		List<Employee> list=adminDao.getallemp();
		model.addAttribute("list",list);
		return "admin/allemployee";
	}
	
	@RequestMapping(value="admin/allusers")
	public String allusers(Model model)
	{
		List<Customer> list=customerDao.getallcust();
		model.addAttribute("list",list);
		return "admin/alluser";
	}
	
	

}
