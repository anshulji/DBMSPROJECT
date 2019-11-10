	package com.anshul;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anshul.dao.AppointmentDao;
import com.anshul.dao.BlogDao;
import com.anshul.dao.CustomerDao;
import com.anshul.dao.MessageDao;
import com.anshul.dao.ProdCatDao;
import com.anshul.dao.ProductDao;
import com.anshul.dao.ServiceDao;
import com.anshul.dao.Userdao;
import com.anshul.dao.WishlistDao;
import com.anshul.model.Appointment;
import com.anshul.model.AppointmentTable;
import com.anshul.model.Blog;
import com.anshul.model.Category;
import com.anshul.model.Comment;
import com.anshul.model.Customer;
import com.anshul.model.Message;
import com.anshul.model.Prod_category;
import com.anshul.model.Product;
import com.anshul.model.Services;
import com.anshul.model.User;

@Controller
public class LoginController {

	@Autowired
	public Userdao userdao;
	@Autowired
	public ServiceDao serviceDao;
	@Autowired
	public ProdCatDao prodcatDao;
	@Autowired
	public ProductDao productDao;
	@Autowired
	public WishlistDao wishlistDao;
	@Autowired
	public BlogDao blogDao;
	@Autowired
	public MessageDao messageDao;
	@Autowired
	public AppointmentDao appointmentDao;
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("allusers")
	public String allusers(Model model)
	{
		List<Customer> list=customerDao.getallcust();
		model.addAttribute("list",list);
		return "admin/alluser";
	}
	
	@RequestMapping("home")
	public String hello(Model model) {
		List<Services> list=serviceDao.getServices();
		model.addAttribute("services_list",list);
		return "home";
	}
	
	
	@RequestMapping(value="appointment",method=RequestMethod.GET)
	public String appointment(Model model,Authentication authentication,Principal principal) {
		if(authentication!=null)
		{
			model.addAttribute("appointment",new Appointment());
			List<AppointmentTable> list = appointmentDao.getAppointmentsByUsername(principal.getName());
			
			System.out.print("tre"+list.size());
			model.addAttribute("list",list);
			return "appointment";
		}
		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";
		
	}
	
	@RequestMapping(value="appointment",method=RequestMethod.POST)
	public String appointmentpost(@ModelAttribute("appointment") Appointment appointment,Model model,Authentication authentication,Principal principal) {
		appointment.setStatus_id(1);
		appointment.setUsername(principal.getName());
		appointmentDao.addApp(appointment);
		List<AppointmentTable> list = appointmentDao.getAppointmentsByUsername(principal.getName());
		model.addAttribute("list",list);
		return "appointment";
		
	}
	
	@RequestMapping("contact")
	public String contact(Model model) {
		
		Message message = new Message();
		model.addAttribute("message",message);
		return "contact";
	}
	
	@RequestMapping(value="submitmessage",method=RequestMethod.POST)
	public String submitMessage( @ModelAttribute("message") Message message,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		else {
			//System.out.print("mess"+message.getName());
			messageDao.addMessage(message);
			return "home";
		}
	}
	
	@RequestMapping("blog")
	public String blog(Model model) {
		List<Blog> list=blogDao.getBlogs();
		model.addAttribute("list",list);
		return "blog";
	}
	
	@RequestMapping(value="blogcontent/{blogid}",method=RequestMethod.GET)
	public String blogcontent(@PathVariable(value="blogid") int blogid,Model model,Authentication authentication,Principal principal) 
	{
		/*if(authentication!=null)
		{*/
			Blog blog=blogDao.getBlogById(blogid);
			model.addAttribute("blog",blog);
			List<Comment> comments = blogDao.getCommentsByBlogId(blogid);
			model.addAttribute("list",comments);
			model.addAttribute("comment",new Comment());
			model.addAttribute("blogid",blogid);
			return "blogcontent";
//		}
//		Customer customer = new Customer();
//		model.addAttribute("user",customer);
//		return "login";
	}
	
	@RequestMapping(value="blogcontent/submit",method=RequestMethod.POST)
	public String blogcontentsubmit(@ModelAttribute("blogid") int blogid,@ModelAttribute("comment") Comment comment,Model model,Authentication authentication,Principal principal) 
	{
			comment.setBlog_id(blogid);
			comment.setDate(Calendar.getInstance().getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			
			java.sql.Time time = new java.sql.Time(Calendar.getInstance().getTimeInMillis()); 
			comment.setTime(time);
			comment.setUsername(principal.getName());
			blogDao.addComment(comment);
			Blog blog=blogDao.getBlogById(blogid);
			model.addAttribute("blog",blog);
			List<Comment> comments = blogDao.getCommentsByBlogId(blogid);
			model.addAttribute("list",comments);
			model.addAttribute("comment",new Comment());
			return "blogcontent";
	}
	
	@RequestMapping("services")
	public String services(Model model) {
		List<Services> list=serviceDao.getServices();
		model.addAttribute("services_list",list);
		return "services";
	}
	
	@RequestMapping("products")
	public String products(Model model) {
		List<Prod_category> list=prodcatDao.getProdCat();
		model.addAttribute("list",list);
		return "products";
	}
	
	@RequestMapping("productslist/{catid}")
	public String productslist(@PathVariable(value="catid") int catid,Model model) 
	{
		List<Product> list=productDao.getprodbycat(catid);
		model.addAttribute("list",list);
		return "productslist";
	}
	
	@RequestMapping("wishlist/{prodid}")
	public String wishlist(@PathVariable(value="prodid") int prodid,Model model,Authentication authentication,Principal principal) 
	{
		if(authentication!=null)
		{
			String uname = principal.getName();
			wishlistDao.addItemToWishlist(prodid, uname);
			List<Product> list=wishlistDao.getProdInWishlist(uname);
			model.addAttribute("list",list);
			return "wishlist";
		}
		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";
	}
	
	@RequestMapping("wishlistremove/{prodid}")
	public String wishlistremove(@PathVariable(value="prodid") int prodid,Model model,Authentication authentication,Principal principal) 
	{
		if(authentication!=null)
		{
			String uname = principal.getName();
			wishlistDao.removeItemFromWishlist(prodid, uname);
			List<Product> list=wishlistDao.getProdInWishlist(uname);
			model.addAttribute("list",list);
			return "wishlist";
		}
		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";
	}
	
	@RequestMapping("wishlist")
	public String wishlist(Model model,Authentication authentication,Principal principal) 
	{
		if(authentication!=null)
		{
			String uname = principal.getName();
			List<Product> list=wishlistDao.getProdInWishlist(uname);
			model.addAttribute("list",list);
			return "wishlist";
		}
		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";
	}
	
	
	@RequestMapping(value = "/homee")
	public String welcome(Model model) {
		model.addAttribute("name", "Home Page");
		model.addAttribute("description", "Page yet to be completed!");
		return "home";
	}

	
	@RequestMapping("/user")
	public String user(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security USER Custom Login Demo");
		model.addAttribute("description", "Protected page for user !");
		return "user";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, Authentication authentication,Principal principal) {
		if(authentication!=null)
        {
			Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			if (authorities.contains("ROLE_USER")) {
				model.addAttribute("user",principal.getName());
				return "user";
	        }
			else if(authorities.contains("ROLE_ADMIN")) 
			{				
				model.addAttribute("user", principal.getName());
				return "admin";
			}
        }		

		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
//		model.addAttribute("message",
//				"You have successfully logged off from application !");
		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		Customer customer = new Customer();
		model.addAttribute("user",customer);
		return "login";

	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		
		Customer user = new Customer();
		model.addAttribute("user", user);

		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("user") Customer user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		else {
			if(!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "register";
			}
			if(userdao.getUser(user.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "register";
			}
			user.setCust_dor(Calendar.getInstance().getTime());
			userdao.saveOrUpdate(user);
			return "login";
		}
	}
	
	@RequestMapping(value="/user/products")
	public String checker(Model model, Principal principal) {
		
		String user = principal.getName();
		model.addAttribute("user",user);
		model.addAttribute("product","product");
		return "product";
	}
	
}
