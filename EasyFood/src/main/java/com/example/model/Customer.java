package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer1")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int cno;
	private String username;
	private String firstname;
	private String lastname;
	private String mobileno;
	private String password;
	
	public Customer() {
		super();
	}
	public Customer(String username, String firstname, String lastname, String mobileno, String password) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.password = password;
	}
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobileno=" + mobileno + ", password=" + password + "]";
	}
}
