package me.happyzombie;

import java.io.File;
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
			if (WarpData.contains(args[1])){	
					
					
					WarpData.set(args[1],  null);
					WarpData.set(args[1] +".world", null);
					WarpData.set(args[1] +".X", null);
					WarpData.set(args[1]+".Y", null);
					WarpData.set(args[1]+".Z", null);
					DataManager.saveConfig(WarpData, WarpDataFile);
					player.sendMessage(ChatColor.GREEN + "Warp "+args[1] + " was deleted succesfuly!");
			}else{
				player.sendMessage(ChatColor.RED + "The specified warp already exists.");
			}

		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguements.");
		}
	}
}
