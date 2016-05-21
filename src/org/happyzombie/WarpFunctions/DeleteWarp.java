package org.happyzombie.WarpFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.happyzombie.WarpMain;

public class DeleteWarp {
	
	public static void delete(Player player, WarpMain plugin, String args[]){
		if (args.length == 2){
			String warpName = args[1];
			if (plugin.warps.containsKey(warpName)){	
				plugin.warps.remove(warpName);
				//autosave shit here
				player.sendMessage(ChatColor.GREEN + "Warp " + warpName + " was deleted succesfuly!");
			}else{
				player.sendMessage(ChatColor.RED + "The specified warp doesn't exist.");
			}

		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguements.");
		}
	}
}
