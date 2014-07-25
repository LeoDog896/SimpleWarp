package me.happyzombie.go_to;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpGotoOther {

	public static void gotoOther(Player player, String args[]){
	
	if (player.hasPermission("warpGotoOther")){
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName()+File.separator+args[1]+".yml");
		if (WarpDataFile.exists()){
			WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
			double x = (WarpData.getInt("Warp.X")) + 0.5;
			double y = (WarpData.getInt("Warp.Y")) + 0.5;
			double z = (WarpData.getInt("Warp.Z")) + 0.5;
			boolean playerFound = false;
			for (Player playerToWarp : Bukkit.getServer().getOnlinePlayers()){
				if (playerToWarp.getName().equalsIgnoreCase(args[2])){
					Location warp = new Location(player.getWorld(), x, y, z);
					
					playerToWarp.teleport(warp);
					
					player.sendMessage(ChatColor.GREEN + playerToWarp.getName() + " was warped to "+ args[1] +"successfuly.");
					playerToWarp.sendMessage(ChatColor.GOLD + player.getName() + " warped you to "+ args[1]);
					playerFound = true;
					break;
				}
			}
			if (playerFound == false){
				player.sendMessage(ChatColor.RED + args[2] + " could not be found.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "The warp " + args[1] + " does not exist.");
		
		}
		}else{
			player.sendMessage(ChatColor.RED + "You do not have permission to do that.");
	}
	}
}
