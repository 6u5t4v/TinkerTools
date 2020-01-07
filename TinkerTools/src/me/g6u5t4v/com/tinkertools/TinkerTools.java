package me.g6u5t4v.com.tinkertools;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import me.g6u5t4v.com.tinkertools.managers.FileManager;

public class TinkerTools extends JavaPlugin implements Listener {
	public static TinkerTools instance;
	private static HeadDatabaseAPI headAPI;
	
	private static FileManager fileManager = new FileManager();
	
	
	
	private void registerSettings() {

	}

	public void onEnable() {
		instance = this;

		registerConfigs();
		registerSettings();

		registerCommands();
		registerListeners();

		this.getLogger().info("Has been enabled v" + this.getDescription().getVersion());
	}

	private void registerConfigs() {
		fileManager.getConfig("config.yml").copyDefaults(true).save();
		fileManager.getConfig("lang.yml").copyDefaults(true).save();
	}

	public void reloadPlugin() {
		for (FileManager.Config c : FileManager.configs.values()) {
			c.reload();
		}
	}

	private void registerCommands() {
//		getCommand("titles").setExecutor(new TitlesCMD());
	}

	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
	}

	@EventHandler
	public void onDatabaseLoad(DatabaseLoadEvent event) {
		headAPI = new HeadDatabaseAPI();
		try {
			ItemStack item = headAPI.getItemHead("722");
			getLogger().log(Level.INFO, headAPI.getItemID(item));
		} catch (NullPointerException e) {
			getLogger().log(Level.SEVERE, "Could not find the head you were looking for.");
		}
	}
	
	public void onDisable() {
		this.getLogger().info("Has been disabled v" + this.getDescription().getVersion());
	}
	
	public FileManager getFileManager() {
		return fileManager;
	}
	
	public HeadDatabaseAPI getHeadAPI() {
		return headAPI;
	}
}
