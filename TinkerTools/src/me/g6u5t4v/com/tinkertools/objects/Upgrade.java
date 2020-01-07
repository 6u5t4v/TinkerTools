package me.g6u5t4v.com.tinkertools.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class Upgrade {

	private String name;
	private ItemStack item;
	private List<String> applicableItems = new ArrayList<>();
	
	public Upgrade (String name, ItemStack item, List<String> applicable) {
		this.name = name;
		this.item = item;
		this.applicableItems = applicable;
	}

	public String getName() {
		return name;
	}

	public ItemStack getItem() {
		return item;
	}

	public List<String> getApplicableItems() {
		return applicableItems;
	}
	
	
}
