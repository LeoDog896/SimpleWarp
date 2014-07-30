package me.happyzombie.SimpleWarpTests;

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
		for (int i = 0; i < len; i++){
			player.sendMessage(ChatColor.BLUE + Warps[i]);
		}
	}
}
