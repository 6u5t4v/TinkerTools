package me.g6u5t4v.com.tinkertools.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Recipe {

	private ItemStack result;
	private String[] pattern;
	private List<Map<Character, Material>> ingredients = new ArrayList<>();
}
