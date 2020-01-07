package me.g6u5t4v.com.tinkertools.enums;

public enum ItemType {

	HELMET("_HELMET"), CHESTPLATE("_CHESTPLATE"), LEGGINGS("_LEGGINGS"), BOOTS("_BOOTS"), SWORD("_SWORD"), BOW("BOW"),
	PICKAXE("_PICKAXE"), AXE("_AXE"), SHOVEL("_SHOVEL"), SHEAR("SHEAR"), FISHINGROD("FISHING_ROD");

	private String type;

	ItemType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
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
