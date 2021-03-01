package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>  {

	List<Order> findAllByUsername(String username);


}
