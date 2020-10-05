package com.cognizant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.clients.CartClient;
import com.cognizant.dto.CartList;
import com.cognizant.dto.MenuItem;
import com.cognizant.exception.ItemNotFoundException;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartClient cartClient;
	
	private Long id=null;
	@GetMapping("/menus")
	public String getAllCartItems(ModelMap model) {
		model.put("menuList",cartClient.getMenuItemListCustomer());
		if(id==null)
			return "redirect:/cart";
		model.put("userId",id);
		return "cartmenu";
	}
	@PostMapping("/{userId}/{itemId}")
	public String addToCart(@PathVariable("userId") Long userId, @PathVariable("itemId") Long itemId) {
		String str = cartClient.addToCart(userId,itemId);
		return "redirect:/cart/menus";
	}
	@PostMapping("/add/{userId}/{itemName}")
	public String addToCartFromCart(@PathVariable("userId") Long userId, @PathVariable("itemName") String itemName) {
		List<MenuItem> list = cartClient.getMenuItemListCustomer();
		Long itemIdLocal=null;
		for(MenuItem mi:list){
			if(mi.getName().equalsIgnoreCase(itemName))
				itemIdLocal=mi.getId();
		}
		String str = cartClient.addToCart(userId,itemIdLocal);
		return "redirect:/cart/user";
	}
	@PostMapping("/delete/{userId}/{itemName}")
	public String deleteFromCart(@PathVariable long userId,@PathVariable String itemName) throws ItemNotFoundException{
		List<MenuItem> list = cartClient.getMenuItemListCustomer();
		Long itemIdLocal=null;
		for(MenuItem mi:list){
			if(mi.getName().equalsIgnoreCase(itemName))
				itemIdLocal=mi.getId();
		}
		String str = cartClient.deleteFromCart(userId, itemIdLocal);
		return "redirect:/cart/user";
	}
	@GetMapping("/user")
	public String getAllFromCart(ModelMap model) {
		CartList cartList = cartClient.getAllFromCart(id);
		model.put("cartList",cartList);
		model.put("userId", id);
		return "usercart";
	}
	@GetMapping
	public String adduser() {
		return "saveuser";
	}
	@PostMapping
	public String setUserId(@RequestParam("userId") Long userId) {
		this.id = userId;
		return "redirect:/cart/menus";
	}
}
