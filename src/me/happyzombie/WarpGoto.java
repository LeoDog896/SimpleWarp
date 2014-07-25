package me.happyzombie;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpGoto {
	
	public static void gotoWarp (Player player, String args[]){
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName()+File.separator+args[1]+".yml");
		int length = args.length;
		if (length == 2){
			if (player.hasPermission("warpGoto")){
			if (WarpDataFile.exists()){
				WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
				double x = (WarpData.getInt("Warp.X")) + 0.5;
				double y = (WarpData.getInt("Warp.Y")) + 0.5;
				double z = (WarpData.getInt("Warp.Z")) + 0.5;
			
				Location warp = new Location(player.getWorld(), x, y, z);
			
				player.teleport(warp);
				DataManager.saveConfig(WarpData, WarpDataFile);
				player.sendMessage(ChatColor.GOLD + "You have been teleported to "+args[1]);
			}else{
				player.sendMessage(ChatColor.RED + "Warp "+args[1] +" does not exist.");
			}
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to do that.");
			}
		}else if (length == 3){
			if (player.hasPermission("warpGotoOther")){
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
		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguments.");
		}
	}
}
