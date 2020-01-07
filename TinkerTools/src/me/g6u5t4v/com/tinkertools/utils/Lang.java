package me.g6u5t4v.com.tinkertools.utils;

import org.bukkit.ChatColor;

public class Lang {

	public static String chat(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
