package com.cognizant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItemStrDate {
	private long id;
	private String name;
	private float price;
	private boolean actv;
	private String dateOfLaunch;
	private String category;
	private boolean freeDelivery;

}