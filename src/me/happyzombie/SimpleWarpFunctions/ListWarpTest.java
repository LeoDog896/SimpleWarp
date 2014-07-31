package me.happyzombie.SimpleWarpFunctions;

import java.io.File;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ListWarpTest {
	
	public static void listWarps(Player player, String args[]){
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
		
		Set<String> WarpNames;
		WarpNames = WarpData.getConfigurationSection("main").getKeys(false);
		int len = WarpNames.size();
		String[] Warps = WarpNames.toArray(new String[0]);
		if (args.length == 1){
			player.sendMessage(ChatColor.BLUE + "List of warps in all worlds.");
			for (int i = 0; i < len; i++){
				player.sendMessage(ChatColor.BLUE + Warps[i] + " --- " +WarpData.getString("main."+Warps[i]+".world"));
			}
		}else if(args.length == 2){
			player.sendMessage(ChatColor.BLUE + "List of warps in world: "+args[1]);
			boolean found = false;
			for (int i = 0; i < len; i++){
				if (args[1].equals(WarpData.getString("main."+Warps[i]+".world"))){
					player.sendMessage(ChatColor.BLUE + Warps[i] + " --- " +WarpData.getString("main."+Warps[i]+".world"));
					found = true;
				}
			}
			if(found == false){
				player.sendMessage(ChatColor.RED + "No warps found for "+args[1]+", remember world search is case sensitive!");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Invalid arguments.");
		}
	}
}
