package me.g6u5t4v.com.tinkertools.enums;

import org.bukkit.inventory.ItemStack;

public enum ItemType {

	HELMET("_HELMET"), CHESTPLATE("_CHESTPLATE"), LEGGINGS("_LEGGINGS"), BOOTS("_BOOTS"), SWORD("_SWORD"), BOW("BOW"),
	PICKAXE("_PICKAXE"), AXE("_AXE"), SHOVEL("_SHOVEL"), SHEAR("SHEAR"), FISHINGROD("FISHING_ROD"), TRIDENT("TRIDENT");

	private String type;

	ItemType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public boolean isEnchantable(ItemStack item) {
		for(ItemType enchantable : ItemType.values()) {
			if(item.getType().toString().contains(enchantable.getType())) {
				return true;
			}
		}
		return false;
	}
	
	public String getItemType(String isType) {
		for (ItemType str : ItemType.values()) {
			if (str.getType().equals(isType)) {
				return str.getType();
			}
		}

		return isType + " is not an upgradable item";
	}
}
