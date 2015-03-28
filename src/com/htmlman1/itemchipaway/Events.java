package com.htmlman1.itemchipaway;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.htmlman1.itemchipaway.util.Data;

public class Events implements Listener {

	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent event) {
		if(Data.willOccur(Main.plugin.getConfig().getDouble("chance"))) {
			Entity damaged = event.getEntity();
			if(damaged instanceof Player) {
				Player damagee = (Player) damaged;
				if(!damagee.hasPermission("itemchipaway.exempt")) {
					Inventory inv = damagee.getInventory();
					List<Integer> slots = Data.getEligibleSlots(inv);
					if((slots != null) && (!slots.isEmpty())) {
						int target = Data.getRandomSlot(slots);
						ItemStack hit = inv.getItem(target);
						inv.setItem(target, new ItemStack(Material.AIR));
						damagee.getWorld().dropItemNaturally(damagee.getLocation(), hit);
					}
				}
			}
		}
	}
	
}
