package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ano;
	public String username;
	public String houseno;
	public String flat;
	public String landmark;
	public String area;
	public String city;
	public String state;
	public String pincode;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address(String username, String houseno, String flat, String landmark, String area, String city,
			String state, String pincode) {
		super();
		this.username = username;
		this.houseno = houseno;
		this.flat = flat;
		this.landmark = landmark;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [ano=" + ano + ", username=" + username + ", houseno=" + houseno + ", flat=" + flat
				+ ", landmark=" + landmark + ", area=" + area + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}