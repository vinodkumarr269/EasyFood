package com.example.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	public final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public String registerCustomer(Customer customer) {
		String password = customer.getPassword();
		String username = customer.getUsername();
		String status = null;
		if (checkPassword(password).equals("success") && checkUserName(username).equals("success")) {
			customerRepository.save(customer);
			status = "complete";
		} 
	    else if (checkPassword(password).equals("success") && checkUserName(username).equals("fail")) {
			status = "usernameExisting";
		}
	    else if (checkPassword(password).equals("fail") && checkUserName(username).equals("fail")) {
			status = "usernameExisting";
		}
	    else {
			status = "passwordNotMatching";
	    }
		return status;
	}

	public String checkPassword(String password) {
		String status = null;
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password); 
		if (password.length() >= 8 && m.matches()) {
			status = "success";
		} else {
			status = "fail";
		}
		return status;
	}

	public String checkUserName(String username) {
		String status = null;
		if (findByUsername(username) == null) {
			status = "success";
		} else {
			status = "fail";
		}
		return status;
	}

	public Customer findByUsernameAndPassword(String username, String password) {
		return customerRepository.findByUsernameAndPassword(username, password);
	}

	public Customer findByUsername(String username) {
		return customerRepository.findByUsername(username);
	}

	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

}
