package me.g6u5t4v.com.tinkertools.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import me.g6u5t4v.com.tinkertools.objects.Upgrade;

public class UpgradeItem extends Event implements Cancellable {

	private HandlerList handlerList = new HandlerList();

	private boolean cancelled;

	private Player player;
	private ItemStack item;
	private Upgrade upgrade;

	public UpgradeItem(Player player, ItemStack item, Upgrade upgrade) {
		this.player = player;
		this.item = item;
		this.upgrade = upgrade;
	}

	public Player getPlayer() {
		return player;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public Upgrade getUpgrade() {
		return upgrade;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return cancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		this.cancelled = arg0;

	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlerList;
	}
}
