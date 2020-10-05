package com.cognizant.controler;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.dto.CartItem;
import com.cognizant.dto.CartList;
import com.cognizant.model.Cart;
import com.cognizant.model.MenuItem;
import com.cognizant.service.CartService;
@SpringBootTest
@AutoConfigureMockMvc
class CartControlerTest {
	@MockBean
	private CartService cartService;
	@Autowired
	MockMvc mock;
	@Test
	void testGetAllMenuItem() throws Exception {
		List<MenuItem> list = new ArrayList<>();
		list.add(new MenuItem(100L, "Sandwich", 200, true, new SimpleDateFormat("dd-MM-yyyy").parse("20-09-2020"),
				"Starter", true));
		when(cartService.showAllMenuItem()).thenReturn(list);
		mock.perform(get("/cart/menus")).equals(list);
	}

	@Test
	void testGetAllFromCart() throws Exception {
		List<MenuItem> list = new ArrayList<>();
		MenuItem menuItem = new MenuItem(500L, "Chicken Tandoori", 200, true,
		new SimpleDateFormat("dd-MM-yyyy").parse("20-09-2020"), "Starter", true);
		list.add(menuItem);
		Cart cart = new Cart(1,1L, 500L, 2);
		List<Cart> cartList = new ArrayList<>();
		cartList.add(cart);
		CartItem c = new CartItem(menuItem.getName(), menuItem.getPrice(), menuItem.getCategory(),
		menuItem.isFreeDelivery(), cart.getCount());
		List<CartItem> ci = new ArrayList<>();
		ci.add(c);
		CartList cartList1 = new CartList(ci, (long) (menuItem.getPrice() * cart.getCount()));
		when(cartService.getAllFromCart(1L)).thenReturn(cartList1);
		mock.perform(get("/cart/1")).equals(list);
	}

	@Test
	void testAddToCart() throws Exception {
		when(cartService.addToCart(1, 500)).thenReturn("Item Successfully Added to Cart");
		mock.perform(post("/cart/addtocart/1/500")).equals("Item Successfully Added to Cart");
	}

	@Test
	void testDeleteFromCart() throws Exception {
		when(cartService.deleteCartItem(1, 500)).thenReturn("SuccessFully Deleted the item from cart.");
		mock.perform(delete("/cart/delete/1/500")).equals("SuccessFully Deleted the item from cart.");
	}

}
