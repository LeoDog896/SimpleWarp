package org.happyzombie.WarpFunctions;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.happyzombie.DataManager;
import org.happyzombie.WarpMain;
import org.happyzombie.Objects.Warp;

public class SaveWarps {

	public static boolean saveWarps(Player player, WarpMain plugin){
			
		FileConfiguration WarpData = null;

		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
		if(!WarpDataFile.exists()){
			try {
				WarpDataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
		
		for (Entry<String, Warp> w : plugin.warps.entrySet()){
			if (!WarpData.contains("warps." + w.getKey())){
				WarpData.set("warps." + w.getKey() +".world", w.getValue().getWorldID().toString());
				WarpData.set("warps." + w.getKey() + ".X", w.getValue().getX());
				WarpData.set("warps." + w.getKey() + ".Y", w.getValue().getY());
				WarpData.set("warps." + w.getKey() + ".Z", w.getValue().getZ());
			}else{}
		}
		DataManager.saveConfig(WarpData, WarpDataFile);
		player.sendMessage(ChatColor.GREEN + "Saved.");
		return true;
	}
}