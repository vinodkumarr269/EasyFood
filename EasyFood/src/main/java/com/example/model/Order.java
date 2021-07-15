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
	private String itemname;
	private int price;
	private String hotelname;
	private int orderno;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(String username, int totalprice) {
		super();
		this.username = username;
		this.totalprice = totalprice;
	}
	
	
	
	public Order(String username, int totalprice, String itemname, int price, String hotelname) {
		super();
		this.username = username;
		this.totalprice = totalprice;
		this.itemname = itemname;
		this.price = price;
		this.hotelname = hotelname;
	}


	public int getOrderno() {
		return orderno;
	}


	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}


	public Order(String username, int totalprice, String itemname, int price, String hotelname, int orderno) {
		super();
		this.username = username;
		this.totalprice = totalprice;
		this.itemname = itemname;
		this.price = price;
		this.hotelname = hotelname;
		this.orderno = orderno;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getHotelname() {
		return hotelname;
	}


	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}


	public int getTotalprice() {
		return totalprice;
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
