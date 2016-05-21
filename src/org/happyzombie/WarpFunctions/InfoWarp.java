package org.happyzombie.WarpFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.happyzombie.WarpMain;

public class InfoWarp {

	public static boolean warpInfo(Player player, WarpMain plugin, String args[]){
		if (args.length >= 2){
			String warpName = args[1];
			if(plugin.warps.containsKey(warpName)){
			player.sendMessage(ChatColor.BLUE + "Information for warp: "+warpName+".");
			player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.WHITE + plugin.warps.get(warpName).getWorldID().toString());
			player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.WHITE + plugin.warps.get(warpName).getX());
			player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.WHITE + plugin.warps.get(warpName).getY());
			player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.WHITE + plugin.warps.get(warpName).getZ());
			}else{
				player.sendMessage(ChatColor.RED + "Specified warp does not exist.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguments.");
		}
		return true;
	}
}
