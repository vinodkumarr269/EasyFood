package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cno;
	private String username;
	private int hno;
	private int ino;
	private String itemname;
	private int price;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(String username, int hno, int ino, String itemname, int price) {
		super();
		this.username = username;
		this.hno = hno;
		this.ino = ino;
		this.itemname = itemname;
		this.price = price;
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

	
	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
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

	@Override
	public String toString() {
		return "Cart [cno=" + cno + ", username=" + username + ", hno=" + hno + ", ino=" + ino + ", itemname="
				+ itemname + ", price=" + price + "]";
	}

	
	

}
