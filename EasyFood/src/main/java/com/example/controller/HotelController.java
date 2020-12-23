package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Cart;
import com.example.model.Hotel;
import com.example.model.Items;
import com.example.service.CartService;
import com.example.service.HotelService;
import com.example.service.ItemsService;

@Controller
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	@Autowired
	ItemsService itemsService;
	@Autowired
	CartService cartService;
	ModelAndView model = new ModelAndView();
	@GetMapping("/addHotelByAdmin")
	public ModelAndView openHotelRegistrtion() {
		model.setViewName("addHotel");
		return model;
	}
	@GetMapping("/register-hotel")
	public ModelAndView addHotels(@ModelAttribute Hotel hotel,BindingResult bindingResult) {
		hotelService.save(hotel);
		model.setViewName("adminAccess");
		return model;
	}
	@GetMapping("/getAllHotels")
	public ModelAndView getAllHotels() {
		List<Hotel> hotel=hotelService.getAllHotes();
		model.addObject("hotels",hotel);
		model.setViewName("showAllHotels");
		return model;
	}
	@GetMapping("/openAddItemsPage")
	public ModelAndView openAddItemsPage(@RequestParam int hno) {
		model.addObject("hno",hno);
		model.setViewName("addItems");
		return model;
	}
	@GetMapping("/addItemsToHotel")
	public ModelAndView addItems(@RequestParam int hno,@RequestParam String itemname, @RequestParam int price) {
		Items item = new Items(hno, itemname, price);
		itemsService.addItems(item);
		model.addObject("hno",hno);
		model.setViewName("addItems");
		return model;
	}
	@GetMapping("/displayAllHotels")
	public ModelAndView displayAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotes();
		model.addObject("hotels",hotels);
		model.addObject("mode","MODE_All_HOTELS");
		model.setViewName("EasyFood");
		return model;
		}
	@GetMapping("/getAllItemsByHno")
	public ModelAndView getItemsByHno(@RequestParam int hno) {
		List<Items> items = itemsService.getAllItemsByHno(hno);
		model.addObject("items",items);
		model.setViewName("getitems");
		return model;
		}
	@GetMapping("/addItemsToCart")
	public ModelAndView addItemsToCart(@RequestParam int ino,@RequestParam int hno, @RequestParam String itemname,@RequestParam int price ,
			HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		Cart cart = new Cart(username, hno, ino, itemname, price);
		cartService.addToCart(cart);
		model.setViewName("getitems");
		return model;
		}
	@GetMapping("/displayCart")
	public ModelAndView diplayCartItems(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cartItems=cartService.getAllCartItems(username);
		int total=cartService.findTotalCartValue(cartItems);
		model.addObject("total",total);
		model.addObject("cartItems",cartItems);
		model.setViewName("showCart");
		return model;
	}
	@GetMapping("/removeItemsfromcart")
	public ModelAndView removeItems(@RequestParam int cno,HttpServletRequest request) {
		cartService.removesItemFromCart(cno);
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cartItems = cartService.getAllCartItems(username);
		int total=cartService.findTotalCartValue(cartItems);
		model.addObject("total",total);
		model.setViewName("showCart");
		model.addObject("cartItems",cartItems);
		return model;
	}

}
