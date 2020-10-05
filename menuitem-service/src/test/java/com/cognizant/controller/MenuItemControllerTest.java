package com.cognizant.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.model.MenuItem;
import com.cognizant.service.MenuItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@AutoConfigureMockMvc
class MenuItemControllerTest {
	@MockBean
	MenuItemService service;
	@Autowired
	MockMvc mock;
	List<MenuItem> menu=new ArrayList<>();
	@BeforeEach
	public void init() {
		menu.add(new MenuItem(1,"chocolate brownies",150,true,new Date("25/06/2012"),"Dessert",true));
	}
	
	@Test
	void testGetMenuItemListCustomer() throws Exception{
		when(service.findAll()).thenReturn(ResponseEntity.status(HttpStatus.OK).body(menu));
		mock.perform(get("/menuitems")).equals(menu);
	}
	@Test
	void testGetMenuItemById() throws Exception {
		MenuItem m=new MenuItem(5L,"Cold drinks",150,true,new Date("25/06/2012"),"Dessert",true);
		when(service.findById(5L)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(m));
		mock.perform(get("/menuitems/5")).equals(menu);
	}

	@Test
	void testAddMenuItem() throws Exception{
		MenuItem m=new MenuItem(5L,"Cold drinks",150,true,new Date("25/06/2012"),"Dessert",true);
		when(service.save(m)).thenReturn("Item added successfully");
		 ObjectMapper mapper = new ObjectMapper();
		 String str = mapper.writeValueAsString(m);
		 mock.perform(
		  post("/menuitems/addtocart")
		  .contentType(MediaType.APPLICATION_JSON)
		  .content(str));
	}

	@Test
	void testUpdateMenuItem() throws Exception {
		MenuItem menu=new MenuItem(5L,"Ice Cream",150,true,new Date("25/06/2012"),"Dessert",true);
		when(service.updateMenuItem(menu)).thenReturn("Updated successfully");
		ObjectMapper mapper = new ObjectMapper();
		 String str = mapper.writeValueAsString(menu);
		 mock.perform(
		  post("/menuitems/update").contentType(MediaType.APPLICATION_JSON).content(str));
		
	}

	@Test
	void testDeleteMenuItemById() throws Exception {
		when(service.deleteMenuItem(1L)).thenReturn("Menu id "+ 1 +" deleted successfully");
		mock.perform(delete("/menuitems/delete/1")).andExpect(status().isOk());
	}

}
