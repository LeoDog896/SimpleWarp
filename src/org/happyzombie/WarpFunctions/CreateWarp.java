package org.happyzombie.WarpFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.happyzombie.WarpMain;
import org.happyzombie.Objects.Warp;

public class CreateWarp {
	
	public static void create(Player player, WarpMain plugin, String args[]){
		if (args.length == 2){
			String warpName = args[1];
			if(!plugin.warps.containsKey(warpName)){
				plugin.warps.put(warpName, new Warp(warpName, player.getLocation()));
				player.sendMessage(ChatColor.GREEN + "Warp " + warpName + " created successfully.");
				//add autosave shit here
			}else{
				player.sendMessage(ChatColor.RED + "Warp " + warpName + " already exists.");
			}	
		}
	}
}
