package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Hotel;
public interface HotelRepository extends CrudRepository<Hotel, Integer>  {


}
