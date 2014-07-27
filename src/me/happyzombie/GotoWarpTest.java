package me.happyzombie;

import java.io.File;

import me.happyzombie.DataManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class GotoWarpTest {
	
	public static void gotoWarp (Player player, String args[]){
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
			if (player.hasPermission("warpGoto")){
				WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
				if (WarpData.contains(args[1])){
					String name = (WarpData.getString(args[1] + ".name"));
					double x = (WarpData.getInt(args[1] + ".X")) + 0.5;
					double y = (WarpData.getInt(args[1] + ".Y")) + 0.5;
					double z = (WarpData.getInt(args[1] + ".Z")) + 0.5;
			
				Location warp = new Location(Bukkit.getServer().getWorld(name), x, y, z);
			
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
