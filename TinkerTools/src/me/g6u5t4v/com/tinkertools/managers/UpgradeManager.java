package me.g6u5t4v.com.tinkertools.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import me.g6u5t4v.com.tinkertools.TinkerTools;
import me.g6u5t4v.com.tinkertools.objects.Upgrade;
import me.g6u5t4v.com.tinkertools.utils.ItemUtils;

public class UpgradeManager {

	private TinkerTools plugin;
	
	public UpgradeManager(TinkerTools plugin) {
		this.plugin = plugin;
	}
	
	private List<Upgrade> upgrades = new ArrayList<>();
	
	public void loadUpgrades() {
		FileConfiguration file = plugin.getFileManager().getConfig("config.yml").get();
	
		ConfigurationSection upgradesSection = file.getConfigurationSection("upgrades");
		
		upgrades.clear();
		if(upgradesSection != null) {
			for(String upgradeName : upgradesSection.getKeys(false)) {
				if(upgradeName != null) {
					List<String> applicableType = new ArrayList<>();
					for(String types : file.getStringList("upgrades." + upgradeName + ".stats.applies")) {
						String type = file.getString("upgrades." + upgradeName + ".stats.applies." + types);
						applicableType.add(type);
					}
					
					ItemStack upgradeItem = ItemUtils.loadItemFromConfig("config.yml", "upgrades." + upgradeName);
					
					Upgrade upgrade = new Upgrade(upgradeName, upgradeItem, applicableType);
					upgrades.add(upgrade);
				}
			}
		}
	}
	
	public List<Upgrade> getUpgrades(){
		return upgrades;
	}
	
	public Upgrade getUpgrade(String str) {
		for(Upgrade upgrade : upgrades) {
			if(upgrade.getName().equalsIgnoreCase(str)) {
				return upgrade;
			}
		}
		return null;
	}
	
	
}
