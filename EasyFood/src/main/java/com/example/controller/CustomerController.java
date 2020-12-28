package com.example.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.HotelService;

import net.bytebuddy.asm.Advice.Return;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	HotelService hotelService;
	ModelAndView model= new ModelAndView();
	@GetMapping("/")
	public ModelAndView startPage() {
		model.setViewName("start");
		return model;
	}
	@GetMapping("/register")
	public ModelAndView openRegisterForm() {
		model.setViewName("registerCustomer");
		return model;
	}
	@GetMapping("/login")
	public ModelAndView openLoginForm() {
		model.setViewName("loginCustomer");
		return model;
	}
	@PostMapping("/login-customer")
	public ModelAndView   LoginCustomer(@RequestParam String username,@RequestParam String password
			,HttpServletRequest request) {
		if(customerService.findByUsernameAndPassword(username, password) != null) {	
			HttpSession session=request.getSession(true);
			session.setAttribute("user", username);
			model.setViewName("EasyFood");
		}
		else {
			model.addObject("error",500);
			model.setViewName("loginCustomer");
		}
		return model;
	}
	@PostMapping("/register-customer")
	public ModelAndView registerCustomer(@ModelAttribute Customer customer, BindingResult bindingResult) {
		String status=null;
		status=customerService.registerCustomer(customer);
		if(status.equals("complete")) {
			model.setViewName("start");
		}
		else if(status.equals("usernameExisting")) {
			model.setViewName("registerCustomer");
			model.addObject("x1",1);
		}
		else if(status.equals("passwordNotMatching")) {
			model.setViewName("registerCustomer");
			model.addObject("x2",2);
		}
		return model;
	}
	@GetMapping("/admin")
	public ModelAndView OpenAdminLoginPage() {
		model.setViewName("adminLogin");
		return model;
	}
	@PostMapping("/verifyadmin")
	public ModelAndView adminLogin(@RequestParam String admin,@RequestParam String password) {
		if(admin.equals("vinodkumarr269")&&password.equals("vinodkumar")) {
			model.setViewName("adminAccess");
		}
		else {
			model.addObject("x",1);
			model.setViewName("adminLogin");
		}
		return model;
	}
	@GetMapping("/deleteAllCustomers")
	@ResponseBody
	public String DeleteAllCustomers() {
		customerService.deleteAllCustomers();
		return "deleted";	
	}
	@GetMapping("/deleteAllHotels")
	@ResponseBody
	public String DeleteAllHotels() {
		hotelService.deleteAllHotels();
		return "Hotels Deleted";
	}
	@GetMapping("/createdb")
	@ResponseBody
	public String createDatabase() throws SQLException {
		String url="jdbc:postgresql://localhost:5432/check";
		String driver ="org.postgresql.Driver";
		String user="postgres";
		String password = "root";
		String query="CREATE TABLE customerdemo (\r\n" + 
				"  cno   serial, \r\n" + 
				"  username varchar(45) ,\r\n" + 
				"  firstname varchar(45),\r\n" + 
				"  lastname varchar(45) ,\r\n" + 
				"  mobileno varchar(45) ,\r\n" + 
				"  password varchar(45) \r\n" + 
				");";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "dbCreated";
	}
}
