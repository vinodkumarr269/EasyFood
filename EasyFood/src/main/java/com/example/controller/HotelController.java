package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Address;
import com.example.model.Cart;
import com.example.model.Hotel;
import com.example.model.Items;
import com.example.model.Order;
import com.example.service.AddressService;
import com.example.service.CartService;
import com.example.service.HotelService;
import com.example.service.ItemsService;
import com.example.service.OrderService;

@Controller
public class HotelController {

	@Autowired
	HotelService hotelService;
	@Autowired
	ItemsService itemsService;
	@Autowired
	CartService cartService;
	@Autowired
	AddressService addressService;
	@Autowired
	OrderService orderService;
	ModelAndView model = new ModelAndView();

	@GetMapping("/addHotelByAdmin")
	public ModelAndView openHotelRegistrtion() {
		model.setViewName("addHotel");
		return model;
	}

	@GetMapping("/register-hotel")
	public ModelAndView addHotels(@ModelAttribute Hotel hotel, BindingResult bindingResult) {
		hotelService.save(hotel);
		model.setViewName("adminAccess");
		return model;
	}

	@GetMapping("/getAllHotels")
	public ModelAndView getAllHotels() {
		List<Hotel> hotel = hotelService.getAllHotes();
		model.addObject("hotels", hotel);
		model.setViewName("showAllHotels");
		return model;
	}

	@GetMapping("/openAddItemsPage")
	public ModelAndView openAddItemsPage(@RequestParam int hno) {
		model.addObject("hno", hno);
		model.setViewName("addItems");
		return model;
	}

	@GetMapping("/addItemsToHotel")
	public ModelAndView addItems(@RequestParam int hno, @RequestParam String itemname, @RequestParam int price) {
		Items item = new Items(hno, itemname, price);
		itemsService.addItems(item);
		model.addObject("hno", hno);
		model.setViewName("addItems");
		return model;
	}

	@GetMapping("/displayAllHotels")
	public ModelAndView displayAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotes();
		model.addObject("hotels", hotels);
		model.addObject("mode", "MODE_All_HOTELS");
		model.setViewName("EasyFood");
		return model;
	}

	@GetMapping("/getAllItemsByHno")
	public ModelAndView getItemsByHno(@RequestParam int hno) {
		List<Items> items = itemsService.getAllItemsByHno(hno);
		model.addObject("items", items);
		model.setViewName("getitems");
		return model;
	}

	@GetMapping("/addItemsToCart")
	public ModelAndView addItemsToCart(@RequestParam int ino, @RequestParam int hno, @RequestParam String itemname,
			@RequestParam int price, HttpServletRequest request) {
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
		List<Cart> cartItems = cartService.getAllCartItems(username);
		if(cartItems.size() == 0) {
			model.clear();
			model.addObject("qempty",1);
			model.setViewName("showCart");
			return model;
			}else {
		int total = cartService.findTotalCartValue(cartItems);
		model.clear();
		model.addObject("notempty",2);
		model.addObject("total", total);
		model.addObject("cartItems", cartItems);
		model.setViewName("showCart");
		return model;
			}
	}

	@GetMapping("/removeItemsfromcart")
	public ModelAndView removeItems(@RequestParam int cno, HttpServletRequest request) {
		cartService.removesItemFromCart(cno);
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cartItems = cartService.getAllCartItems(username);
		int total = cartService.findTotalCartValue(cartItems);
		model.addObject("total", total);
		model.setViewName("showCart");
		model.addObject("cartItems", cartItems);
		return model;
	}

	@GetMapping("/get-saved-addresses")
	public ModelAndView getAllAddress(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		if (addressService.getAllAddresses(username).size() == 0) {
			model.setViewName("showAddresses");
		} else {
			model.addObject("x",1);
			model.addObject("addresses", addressService.getAllAddresses(username));
			model.setViewName("showAddresses");
		}
		return model;
	}

	@RequestMapping("/add-address")
	public String openAddAddress() {
		return "addAddress";
	}

	@GetMapping("/add-address-into-database")
	public ModelAndView addAddress(@ModelAttribute Address address, BindingResult bindingResult, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		Address a = new Address(username, address.getHouseno(), address.getFlat(), address.getLandmark(),
				address.getArea(), address.getCity(), address.getCity(), address.getPincode());
		addressService.addAddress(a);
		model.addObject("x",1);
		model.addObject("addresses", addressService.getAllAddresses(username));
		return model;
	}
	@GetMapping("/over-all-summary")
	public ModelAndView overAll(@RequestParam int ano,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("user");
		Address a= addressService.getAddressByAno(ano);
		List<Cart> cart =cartService.getAllCartItems(username);
		int total=cartService.findTotalCartValue(cart);
		Map<Integer, Integer> hno=cartService.getAllHotelNumbers(cart);
		model.addObject("address",a);
		model.addObject("cart",cart);
		model.addObject("total",total);
		model.setViewName("overAllSummaryPage");
		return model;
	}
	@GetMapping("/apply-offer")
	public ModelAndView openApplyOffer(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = cartService.getAllCartItems(username);
		int total=cartService.findTotalCartValue(cart);
		model.addObject("totalprice", total);
		model.setViewName("applyoffer");
		return model;
	}
	
	@GetMapping("/applycoupon")
	public ModelAndView applyOffer(@RequestParam String coupon,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = cartService.getAllCartItems(username);
		int total = cartService.findTotalCartValue(cart);
		int count = orderService.findAllOrderstByUsername(username).size();
		int totalPrice = orderService.calculateOfferValue(coupon, count, total);
		Order order = new Order(username, totalPrice);
		orderService.saveOrder(order);
    	model.addObject("sum", totalPrice);
		model.setViewName("totalpricepage");
		return model;
	}
	@GetMapping("/account")
	public ModelAndView openAccount(HttpServletRequest request) {
		model.addObject("mode", "MODE_ACCOUNT");
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		model.addObject("username", username);
		model.setViewName("EasyFood");
		return model;
	}

	@GetMapping("/accountdetails")
	public ModelAndView accountDetails(HttpServletRequest request) {
		model.setViewName("EasyFood");
		return model;

	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.setViewName("start");
		return model;
	}

	@RequestMapping("/help")
	public String openHelpPage() {
		return "helppage";
	}
	@GetMapping("/payments")
	public ModelAndView openPaymentsPage() {
		model.setViewName("paymentspage");
		return model;
	}

	@GetMapping("/orderplace")
	@ResponseBody
	public String status() {
		return "Order Placed Successfully";
	}
}
