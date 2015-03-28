package com.htmlman1.itemchipaway.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.htmlman1.itemchipaway.Main;

public class Data {
	
	private static Random rand = new Random();

	public static List<Integer> getEligibleSlots(Inventory inv) {
		List<Integer> slots = new ArrayList<Integer>();
		List<Material> queries = new ArrayList<Material>();
		
		List<String> listed = Main.plugin.getConfig().getStringList("items");
		if((listed != null) && (!listed.isEmpty())) {
			for(String l : listed) {
				Material conv = Material.getMaterial(l);
				if(conv != null) {
					queries.add(conv);
				} else {
					Main.plugin.getLogger().warning("In configured item list: type " + l + " not recognized.");
				}
			}
		}
		
		if((queries != null) && (!queries.isEmpty())) {
			for(Material q : queries) {
				HashMap<Integer, ? extends ItemStack> hits = inv.all(q);
				for(Map.Entry<Integer, ? extends ItemStack> e : hits.entrySet()) {
					slots.add(e.getKey());
				}
			}
		}
		
		return slots;
	}
	
	public static Integer getRandomSlot(List<Integer> slots) {
		return slots.get(rand.nextInt(slots.size()));
	}
	
	public static boolean willOccur(double chance) {
		if(rand.nextDouble() <= (chance / 100D)) {
			return true;
		}
		return false;
	}
	
}
