package com.cognizant.clients;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.dto.MenuItem;

import feign.Headers;
@Headers("Content-Type: application/json")
@FeignClient(name="menuitem-service",url="${feign.url}/menuitems")
//@FeignClient(name="menuitem-service" , url="http://group2-lb-683142959.us-east-2.elb.amazonaws.com/menuitems")
public interface MenuClient {
	@GetMapping
	public ResponseEntity<List<MenuItem>> getMenuItemListCustomer();
	@GetMapping("/{id}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id);
	
	@PostMapping("/add")
	public String addMenuItem(@Valid @RequestBody MenuItem newItem);
	
	@PutMapping("/update")
	public String updateMenuItem(@Valid @RequestBody MenuItem menuItem);
	
	@DeleteMapping("/delete/{id}")
	public String deleteMenuItemById(@PathVariable Long id);
}
