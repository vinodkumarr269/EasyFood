package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.model.Cart;
import com.example.model.Order;
import com.example.repository.CartRepository;

@Service
public class CartService {
	CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public void addToCart(Cart cart) {
		cartRepository.save(cart);

	}

	public List<Cart> getAllCartItems(String username) {
		List<Cart> cartItems = new ArrayList<Cart>();
		for (Cart cart : cartRepository.findAllByUsername(username)) {
			cartItems.add(cart);
		}

		return cartItems;
	}

	public void removesItemFromCart(int cno) {
		cartRepository.deleteById(cno);
	}
	public int findTotalCartValue(List<Cart> cartItems) {
		int total=0;
		for(Cart cart :cartItems) {
			total=total+cart.getPrice();
		}
		return total;
	}
	public Map<Integer,Integer> getAllHotelNumbers(List<Cart> cartItems){
		HashMap<Integer, Integer> hno=new HashMap<Integer, Integer>();
		for(Cart cart:cartItems) {
			hno.put(cart.getCno(),cart.getHno());
		}
		return hno;
	}

}
