package me.happyzombie.SimpleWarpTests;

import java.io.File;
import java.io.IOException;

import me.happyzombie.DataManager;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CreateWarpTest {
	
	public static void create(Player player, String args[]){
		if (args.length == 2){
			FileConfiguration WarpData = null;
			File WarpDir = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps");
			if (!WarpDir.exists()){
				WarpDir.mkdirs();
			}
			File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
			if(!WarpDataFile.exists()){
				try {
					WarpDataFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
					WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
					if (!WarpData.contains(args[1])){
						WarpData.set(args[1] +".world", player.getLocation().getWorld().getName());
						WarpData.set(args[1] +".X", player.getLocation().getBlockX());
						WarpData.set(args[1]+".Y", player.getLocation().getBlockY());
						WarpData.set(args[1]+".Z", player.getLocation().getBlockZ());
						DataManager.saveConfig(WarpData, WarpDataFile);
						player.sendMessage(ChatColor.GREEN + "Warp "+args[1] + " was created succesfuly!");
					}else{
						player.sendMessage(ChatColor.RED + "Warp " + args[1] + " already exists.");
					}

			}else{
				player.sendMessage(ChatColor.RED + "Invalid arguements.");
			}
		}
}
