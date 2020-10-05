package com.cognizant.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.clients.MenuClient;
import com.cognizant.dto.MenuItem;
import com.cognizant.dto.MenuItemStrDate;
@Controller
@RequestMapping("/menuitems")
public class AdminController {

	@Autowired
	MenuClient menuClient;
	
	@GetMapping
	public String getAllMenuItems(Map<String,List<MenuItemStrDate>> model) {
		List<MenuItem> list = menuClient.getMenuItemListCustomer().getBody();
		List<MenuItemStrDate> ls1 = new ArrayList<MenuItemStrDate>();
		for(MenuItem m:list) {
			MenuItemStrDate msd = new MenuItemStrDate(m.getId(),m.getName(),m.getPrice(),m.isActv(),
					new SimpleDateFormat("dd-MM-yyyy").format(m.getDateOfLaunch()),m.getCategory(),m.isFreeDelivery());
			ls1.add(msd);
		}
		model.put("menuList",ls1);
		return "menuitems";
	}
	@GetMapping("/admin/add")
	public String add(@ModelAttribute("add") MenuItem newItem) {

		return "addmenuitem";
	}

	@PostMapping("/admin/add")
	public String addMenuItem(Model model, @ModelAttribute("add") MenuItemStrDate newItem) throws ParseException {
		MenuItem item = new MenuItem(newItem.getId(), newItem.getName(),newItem.getPrice()
				, newItem.isActv(), new SimpleDateFormat("dd-MM-yyyy").parse(newItem.getDateOfLaunch()), newItem.getCategory(), newItem.isFreeDelivery());
		menuClient.addMenuItem(item);
		return "redirect:/menuitems";
	}
	
	@GetMapping("/admin/delete")
	public String getDeletePage(Model model, @ModelAttribute("delete") MenuItem menuItem) {
		model.addAttribute("list", menuClient.getMenuItemListCustomer().getBody());
		System.out.println("menuItem: "+menuItem.getId());
		return "deletemenuitem";
	}

	@PostMapping("/admin/delete")
	public String deleteMenuItem(Model model, @ModelAttribute("delete") MenuItem newMenu) {
		System.out.println("newMenu: "+newMenu.getId());
		model.addAttribute("list", menuClient.getMenuItemListCustomer().getBody());
		menuClient.deleteMenuItemById(newMenu.getId());
        return "redirect:/menuitems";
	}
}
