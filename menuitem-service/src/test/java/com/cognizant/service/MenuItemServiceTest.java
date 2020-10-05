package com.cognizant.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.model.MenuItem;
import com.cognizant.repository.MenuItemRepository;
@SpringBootTest
@AutoConfigureMockMvc
class MenuItemServiceTest {
	@MockBean
	private MenuItemRepository repository;
	@Autowired
	MenuItemService service;
	List<MenuItem> item=new ArrayList<>();
	@Test
	void testFindAll() throws Exception{
		item.add(new MenuItem(1,"chocolate",150,true,new Date("25/06/2012"),"Dessert",true));
		when(repository.findAll()).thenReturn(item);
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(item),service.findAll());
	}
//
	@Test
	void testFindById() throws Exception{
		Optional<MenuItem> menu=Optional.of(new MenuItem(1L,"chocolate",150,true,new Date("25/06/2012"),"Dessert",true));
		when(repository.findById(1L)).thenReturn(menu);
		ResponseEntity<MenuItem> m=service.findById(1L);
		assertThat(m).isNotNull();
	}
//
	@Test
	void testSave() throws Exception{
		MenuItem menu=new MenuItem(1L,"chocolate",150,true,new Date("25/06/2012"),"Dessert",true);
		when(repository.save(menu)).thenReturn(menu);
		assertEquals("Item added successfully",service.save(menu));
	}

	@Test
	void testUpdateMenuItem() throws Exception{
		MenuItem menu=new MenuItem(1L,"chocolate",150,true,new Date("25/06/2012"),"Dessert",true);
		when(repository.findById(1L)).thenReturn(Optional.of(menu));
		 when(repository.save(menu)).thenReturn(menu);
		 assertEquals("Updated successfully",service.updateMenuItem(menu));
	}

	@Test
	void testDeleteMenuItem() throws Exception{
		MenuItem item=new MenuItem(1,"chocolate",150,true,new Date("25/06/2012"),"Dessert",true);
		when(repository.findById(1L)).thenReturn(Optional.of(item));
		 assertEquals("Menu id " + 1 + " deleted successfully",service.deleteMenuItem(1L));
	}

}
