package com.cognizant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.clients.CartClient;
import com.cognizant.dto.MenuItem;

@Controller
public class HelloController {

	@Autowired
	CartClient cartClient;
	@RequestMapping("/hello")
	public String getHelloMvc(Map<String, String> model) {
		model.put("message", "Ani");
		return "hello";
	}
	@RequestMapping("/cart/menus")
	public String getAllMenuItemByCart(Map<String,List<MenuItem>> model) {
		List<MenuItem> list = cartClient.getMenuItemListCustomer();
		model.put("cartList",list);
		return "cartitems";
	}
}
