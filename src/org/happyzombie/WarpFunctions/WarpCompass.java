package org.happyzombie.WarpFunctions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.happyzombie.WarpMain;

public class WarpCompass {
	
	public static void compassDefault(Player player, WarpMain plugin, String args[]){
		Location spawn = (player.getBedSpawnLocation() == null) ? Bukkit.getServer().getWorlds().get(0).getSpawnLocation() : player.getBedSpawnLocation();
		player.setCompassTarget(spawn);
	}
	
	public static void compassSet(Player player, WarpMain plugin, String args[]){
		if (args.length >= 2 & plugin.warps.containsKey(args[1])){
			String warpName = args[1];
				if(plugin.warps.get(warpName).getWorld(plugin).toString().equals(player.getWorld().getName())){
				Location pointTo = plugin.warps.get(warpName).getLocation(plugin);
				player.setCompassTarget(pointTo);
				player.sendMessage(ChatColor.BLUE + "Your compass now points to warp " + args[1]);
			}else{
				player.sendMessage(ChatColor.RED + "Your compass cannot point to a warp in another world!");
			}
		}else{
			player.sendMessage(ChatColor.RED + "The specified warp does not exist.");
		}	
	}
}
