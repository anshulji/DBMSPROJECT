package com.anshul;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anshul.dao.Admindao;
import com.anshul.dao.CustomerDao;
import com.anshul.model.Appointment;
import com.anshul.model.AppointmentTable;
import com.anshul.model.Customer;
import com.anshul.model.Employee;
import com.anshul.model.Message;
import com.anshul.model.Prod_bill;
import com.anshul.model.Prod_bill_items;
import com.anshul.model.Services;
import com.anshul.model.User;
import com.anshul.model.WishlistDemand;

@Controller
public class AdminController {
	
	@Autowired
	Admindao adminDao;
	
	@RequestMapping(value="admin/addbillitem",method=RequestMethod.POST)
	public String addbillitempost(@Valid @ModelAttribute("prod_bill_item") Prod_bill_items prod_bill_items,BindingResult result,Model model) 
	{
		
		
		adminDao.addProd_bill_items(prod_bill_items);
		Prod_bill pb = adminDao.getlatestprodid();
		//System.out.print("hii"+pb.get);
		model.addAttribute("prod_bill",pb);
		List<Prod_bill_items> list = adminDao.getProditemsbyid(pb.getPbill_id());
		model.addAttribute("list",list);
		model.addAttribute("prod_bill_items",new Prod_bill_items());
		return "admin/makebillitems";
	}

	@RequestMapping(value="admin/makebill",method=RequestMethod.GET)
	public String makebill(Model model)
	{
		model.addAttribute("prod_bill",new Prod_bill());
		//model.addAttribute("prod_bill_items",new Prod_bill_items());
		return "admin/makebill";
	}

	@RequestMapping(value="admin/makebill",method=RequestMethod.POST)
	public String makebillpost(@Valid @ModelAttribute("prod_bill") Prod_bill prod_bill,BindingResult result,Model model) 
	{
		prod_bill.setDate(Calendar.getInstance().getTime());
		prod_bill.setAmount(0);
		
		adminDao.addProd_bill(prod_bill);
		Prod_bill pb = adminDao.getlatestprodid();
		//System.out.print("hii"+pb.get);
		model.addAttribute("prod_bill",pb);
		model.addAttribute("list",null);
		model.addAttribute("prod_bill_items",new Prod_bill_items());
		return "admin/makebillitems";
	}
	
	@RequestMapping(value="admin/addservices",method=RequestMethod.GET)
	public String addservicesget(Model model)
	{
		model.addAttribute("service",new Services());
		return "admin/addservices";
	}
	
	@RequestMapping(value="admin/addservices",method=RequestMethod.POST)
	public String addservicespost(@Valid @ModelAttribute("service") Services service,BindingResult result,Model model) 
	{
		adminDao.addService(service);
		List<Services> list=adminDao.getallserv();
		model.addAttribute("list",list);		
		return "admin/allservices";
	}
	
	@RequestMapping(value="admin/allservices")
	public String allserv(Model model)
	{
		List<Services> list=adminDao.getallserv();
		model.addAttribute("list",list);
		return "admin/allservices";
	}
	
	@RequestMapping(value="admin/updateapp/{app_id}",method=RequestMethod.GET)
	public String updateappget(@PathVariable(value="app_id") int app_id,Model model)
	{
		Appointment appointment = adminDao.getAppbyid(app_id);
		model.addAttribute("app",appointment);
		model.addAttribute("appid",app_id);
		return "admin/updateapp";
	}
	
	@RequestMapping(value="admin/updateapp",method=RequestMethod.POST)
	public String updateapppost(@Valid @ModelAttribute("app") Appointment app,BindingResult result,Model model) 
	{
		adminDao.updateapp(app);
		System.out.print(app.getStatus_id()+"stst");
		List<AppointmentTable> list=adminDao.getApp();
		model.addAttribute("list",list);
		return "admin/appointments";
	}
	
	@RequestMapping(value="admin/appointments")
	public String apms(Model model)
	{
		List<AppointmentTable> list=adminDao.getApp();
		model.addAttribute("list",list);
		return "admin/appointments";
	}
	
	@RequestMapping(value="admin/getmessages")
	public String gm(Model model)
	{
		List<Message> list=adminDao.getmessages();
		model.addAttribute("list",list);
		return "admin/messages";
	}
	
	@RequestMapping(value="admin/wishlistdemand")
	public String wd(Model model)
	{
		List<WishlistDemand> list=adminDao.getWishlistDemand();
		model.addAttribute("list",list);
		return "admin/wishlistdemand";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "admin";
	}
}
