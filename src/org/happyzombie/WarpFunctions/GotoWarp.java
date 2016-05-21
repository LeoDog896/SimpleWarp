package org.happyzombie.WarpFunctions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.happyzombie.WarpMain;

public class GotoWarp {
	
	public static void gotoWarp (Player player, WarpMain plugin, String args[]){
		if (args.length == 2){
			if (player.hasPermission("warpGoto")){
				String warpName = args[1];
				if (plugin.warps.containsKey(warpName)){
					Location warp = plugin.warps.get(warpName).getLocation(plugin);
					player.teleport(warp);
					player.sendMessage(ChatColor.GOLD + "You have been teleported to "+args[1]);
				}else{
					player.sendMessage(ChatColor.RED + "Warp " + warpName + " does not exist.");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to do that.");

			}
		}else if(args.length == 3){
			String warpName = args[1];
			Player target = plugin.getServer().getPlayer(args[2]);
			if(player.hasPermission("warpSendTo")){
				if(target != null){
					if(plugin.warps.containsKey(warpName)){
						Location warp = plugin.warps.get(warpName).getLocation(plugin);
						target.teleport(warp);
						player.sendMessage(ChatColor.GOLD + args[2] + " was teleported to " + warpName+".");
						target.sendMessage(ChatColor.GOLD + "You were teleported to " + warpName + " by "+player.getName()+".");
					}else{
						player.sendMessage(ChatColor.RED + "Warp " + warpName + " does not exist.");
					}
				}else{
					player.sendMessage(ChatColor.RED + "Player " + args[2] + " does not exist.");
				}	
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to do that.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguments.");
		}
	}
}