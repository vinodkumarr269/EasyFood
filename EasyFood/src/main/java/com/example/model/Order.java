package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="orderitem")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ono;
	private String username;
	private int totalprice;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(String username, int totalprice) {
		super();
		this.username = username;
		this.totalprice = totalprice;
	}
	

	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	

}
