package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.model.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	HotelRepository hotelRepository;
	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository=hotelRepository;
	}
	public void save(Hotel hotel) {
		hotelRepository.save(hotel);
		
	}
	public List<Hotel> getAllHotes() {
		List<Hotel> hotels=new ArrayList<Hotel>();
		for(Hotel hotel:hotelRepository.findAll()){
			hotels.add(hotel);			
		}
		return hotels;
	}
	public void deleteAllHotels() {
		hotelRepository.deleteAll();
	}
	public Hotel getHotelByHotelNo(int hno) {
		return hotelRepository.findByHno(hno);
	}
	public List<Hotel> findAllByHotelname(String hotelname) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		for (Hotel hotel : hotelRepository.findAllByHotelname(hotelname)) {
			hotels.add(hotel);
		}
		return hotels;
	}
	public Hotel findByHno(int hno) {
		 return	hotelRepository.findByHno(hno);
	}
	

}
