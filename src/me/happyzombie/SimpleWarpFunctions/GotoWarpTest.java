package me.happyzombie.SimpleWarpFunctions;

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
				if (WarpData.contains("main."+args[1])){
					String name = (WarpData.getString("main."+args[1] + ".world"));
					double x = (WarpData.getInt("main."+args[1] + ".X")) + 0.5;
					double y = (WarpData.getInt("main."+args[1] + ".Y")) + 0.5;
					double z = (WarpData.getInt("main."+args[1] + ".Z")) + 0.5;
				
				Location warp = new Location(Bukkit.getServer().getWorld(name), x, y, z);
				player.teleport(warp);
				player.sendMessage(ChatColor.GOLD + "You have been teleported to "+args[1]);
				DataManager.saveConfig(WarpData, WarpDataFile);
			}else{
				player.sendMessage(ChatColor.RED + "Warp "+args[1] +" does not exist.");
			}
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to do that.");

			}
		}
	}
