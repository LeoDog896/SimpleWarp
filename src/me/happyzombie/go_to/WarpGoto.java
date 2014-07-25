package me.happyzombie.go_to;

import java.io.File;

import me.happyzombie.DataManager;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpGoto {
	
	public static void gotoWarp (Player player, String args[]){
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName()+File.separator+args[1]+".yml");
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
		}
	}
