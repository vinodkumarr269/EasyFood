package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

	List<Cart> findAllByUsername(String username);

}
