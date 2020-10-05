package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.dto.CartList;
import com.cognizant.dto.MenuItem;
import com.cognizant.exception.ItemNotFoundException;

import feign.Headers;
@Headers("Content-Type: application/json")
@FeignClient(name="cartitem-service",url="${feign.url}/cart")
//@FeignClient(name="cartitem-service" , url="http://group2-lb-683142959.us-east-2.elb.amazonaws.com/cart")
public interface CartClient {
	@GetMapping("/menus")
	public List<MenuItem> getMenuItemListCustomer();
	@GetMapping("/{userId}")
	public CartList getAllFromCart(@PathVariable long userId);
	@PostMapping("/addtocart/{userId}/{menuItemId}")
	public String addToCart(@PathVariable long userId,@PathVariable long menuItemId);
	@DeleteMapping("/delete/{userId}/{menuItemId}")
	public String deleteFromCart(@PathVariable long userId,@PathVariable long menuItemId) throws ItemNotFoundException;
}