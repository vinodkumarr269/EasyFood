package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Hotel;
public interface HotelRepository extends CrudRepository<Hotel, Integer>  {

	Hotel findByHno(int hno);

	List<Hotel> findAllByHotelname(String hotelname);


}
