package me.g6u5t4v.com.tinkertools.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.g6u5t4v.com.tinkertools.TinkerTools;

public class ItemUtils {
	static TinkerTools plugin = TinkerTools.instance;

	public static ItemStack loadItemFromConfig(String configName, String path) {
		Material m = Material.getMaterial(plugin.getConfig().getString(path + ".material"));
		ItemStack is = m != null ? new ItemStack(m)
				: plugin.getHeadAPI().getItemHead(plugin.getConfig().getString(path + ".material"));

		String displayName = plugin.getConfig().getString(path + ".displayname");

		List<String> lore = plugin.getConfig().getStringList(path + ".lore");

		return create(is, displayName, lore);
	}

	public static List<String> convertLore(List<String> list) {
		List<String> lore = new ArrayList<>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				lore.add(Lang.chat(list.get(i)));
			}
		}
		return lore;
	}

	public static List<String> makeLore(String... string) {
		return Arrays.asList(string);
	}

	public static ItemStack create(ItemStack item, String displayName, List<String> lore) {
		if (item == null) {
			plugin.getLogger().severe("Could not find item: " + displayName);
			return null;
		}

		ItemMeta meta = item.getItemMeta();
		if (displayName != null) {
			meta.setDisplayName(Lang.chat(displayName));
		}

		if (lore != null) {
			meta.setLore(convertLore(lore));
		}

		item.setItemMeta(meta);
//		Debug.Log("test: " + item.getItemMeta().getDisplayName());
		return item;
	}
}
