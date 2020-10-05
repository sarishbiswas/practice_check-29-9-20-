package com.cognizant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private int id;
	private long userId;
	private long menuItemId;
	private int count;
	public Cart(long userId, long menuItemId, int count) {
		super();
		this.userId = userId;
		this.menuItemId = menuItemId;
		this.count = count;
	}
	
}
