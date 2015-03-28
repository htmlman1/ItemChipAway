package com.htmlman1.itemchipaway;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;

	@Override
	public void onDisable() { plugin = null; }
	
	@Override
	public void onEnable() {
		plugin = this;
		
		this.saveDefaultConfig();
		
		String toggleValue = getConfig().getString("toggle");
		boolean isActive = (toggleValue.equalsIgnoreCase("true")) ? true : false;
		
		if(isActive) {
			getLogger().info("ItemChipAway ENABLED due to config values");
			getServer().getPluginManager().registerEvents(new Events(), this);
		} else {
			getLogger().info("ItemChipAway DISABLED due to config values");
		}
	}
	
}
