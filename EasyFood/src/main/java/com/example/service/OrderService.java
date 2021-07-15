package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.model.Hotel;
import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	OrderRepository orderRepository;
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public  List<Order> findAllOrderstByUsername(String username) {
		List<Order> order = new ArrayList<Order>();
		for(Order o: orderRepository.findAllByUsername(username)) {
			order.add(o);
		}
		return order;
	}
	public int calculateOfferValue(String coupon,int count,int sum ) {
		if (coupon.equals("new50") ) {
			sum = (int) (sum * 0.5);
		} else {
			sum = (int) (sum);
		}
		return sum;
	}
	public void saveOrder(List<Order> order) {
		orderRepository.saveAll(order);

	}
	public int getLastOrderNumber() {
		return orderRepository.getLastOrderNo();	
	}

	public List<Order> findCountOfOrders() {
		List<Order> order = new ArrayList<Order>();
		for(Order o: orderRepository.findAll()) {
			order.add(o);
		}
		return order;
	}

	public List<Order> findByOrderNumber(int eachordernumber) {
		List<Order> order = new ArrayList<Order>();
		for(Order o: orderRepository.findAllByOrderno(eachordernumber)) {
			order.add(o);
		}
		return order;
	}

	
}
