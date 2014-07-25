package me.happyzombie;

import org.bukkit.event.Listener;

public class ListenerClass implements Listener {
	
	public ListenerClass(WarpMain plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
}