package com.example.service;

import java.util.ArrayList;
import java.util.List;

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
	

}
