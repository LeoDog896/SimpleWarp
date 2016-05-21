package org.happyzombie.WarpFunctions;
//Imports
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.happyzombie.WarpMain;
import org.happyzombie.Objects.Warp;

public class LoadWarps {
	
	public static Map<String, Warp> loadAllWarps(WarpMain plugin){
		 FileConfiguration WarpData = YamlConfiguration
				 .loadConfiguration(new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml")); //load from config file
		
		Warp holder = new Warp(); //create holder vairable for warps
		Map<String, Warp> allWarps = new HashMap<>(); //list of all warps
		Set<String> warpNames = WarpData.getConfigurationSection("warps").getKeys(false);
		if(warpNames != null){
		for(String warp : warpNames){
			holder = new Warp();
			holder.setName(warp);
			holder.setWorldID(WarpData.getString("warps."+warp+".world"));
			holder.setX(WarpData.getInt("warps."+warp+".X"));
			holder.setY(WarpData.getInt("warps."+warp+".Y"));
			holder.setZ(WarpData.getInt("warps."+warp+".Z"));
			allWarps.put(warp, holder); //add holder to map with name as key
			System.out.print("[Simple Warp]: " + warp + " loaded.");
		}
		}else{
			plugin.getLogger().warning("Could not load any warps.");
		}
		return allWarps; //return warps
	}
}

