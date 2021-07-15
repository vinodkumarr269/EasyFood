package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cart;
@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer> {

	List<Cart> findAllByUsername(String username);

	void deleteByUsername(String username);

}
