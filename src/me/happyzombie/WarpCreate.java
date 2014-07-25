package me.happyzombie;

import java.io.File;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpCreate {
	
	public static void createWarpFile(Player player, String args[]){
		if (args.length == 2){
		FileConfiguration WarpData = null;
		File WarpDir = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName());
		if (!WarpDir.exists()){
			WarpDir.mkdirs();
			player.sendMessage(ChatColor.GOLD + "No folder for world: "+player.getWorld().getName() + " creating it now!");
		}
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName()+File.separator+args[1]+".yml");

		if(!WarpDataFile.exists()){
		    try {
		    	WarpDataFile.createNewFile();
			    WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);

			    WarpData.set("Warp.name", args[1]);
			    
			    WarpData.set("Warp.world", player.getLocation().getWorld().getName());
			    WarpData.set("Warp.X", player.getLocation().getBlockX());
			    WarpData.set("Warp.Y", player.getLocation().getBlockY());
			    WarpData.set("Warp.Z", player.getLocation().getBlockZ());

			    DataManager.saveConfig(WarpData, WarpDataFile);
			    player.sendMessage(ChatColor.GREEN + "Warp "+args[1] + " was created succesfuly!");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}else{
			player.sendMessage(ChatColor.RED + "The warp " + args[1] + " already exists.");
		}
		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguements.");
		}
	}
}
