package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {


	List<Address> findAllByUsername(String username);

	Address findByAno(int ano);
	
	

}
