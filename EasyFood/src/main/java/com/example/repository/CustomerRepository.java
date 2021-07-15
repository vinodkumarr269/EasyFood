package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByUsernameAndPassword(String username,String password);
	public Customer findByUsername(String username);
//	@Transactional
//	@Modifying
//	@Query("update customer1 c set c.password =:updatepassword where c.username =:username")
//	public void updateCustomerPassword(@Param("updatepassword") String updatepassword,@Param("username") String username);
	//public void updateCustomerPassword(String updatepassword, String username);
}
