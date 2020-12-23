package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.model.Customer;
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	public Customer findByUsernameAndPassword(String username,String password);
	public Customer findByUsername(String username);

}
