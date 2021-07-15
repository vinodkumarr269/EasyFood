package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Order;
@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Integer>  {

	List<Order> findAllByUsername(String username);
	@Transactional
	@Query(value = "SELECT orderno FROM orderitem ORDER BY orderno DESC LIMIT 1", nativeQuery = true)
	 int getLastOrderNo();

	List<Order> findAllByOrderno(int eachordernumber);
	


}
