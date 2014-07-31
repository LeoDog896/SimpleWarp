package me.happyzombie.SimpleWarpFunctions;

import java.io.File;

import me.happyzombie.DataManager;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class DeleteWarpTest {
	
	public static void delete(Player player, String args[]){
		if (args.length == 2){
			FileConfiguration WarpData = null;
			File WarpDir = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps");
			if (!WarpDir.exists()){
				WarpDir.mkdirs();
			}
			File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
			
			
					WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
			if (WarpData.contains("main."+args[1])){	
					
					
					WarpData.set("main."+args[1],  null);
					DataManager.saveConfig(WarpData, WarpDataFile);
					player.sendMessage(ChatColor.GREEN + "Warp "+args[1] + " was deleted succesfuly!");
			}else{
				player.sendMessage(ChatColor.RED + "The specified warp doesn't exist.");
			}

		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguements.");
		}
	}
}
