package me.happyzombie.SimpleWarpFunctions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.happyzombie.Objects.Warp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LoadWarps {
	
	static List<Warp> warps = new ArrayList<Warp>();
	
	public static List<Warp> loadAllWarps(){
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
	
		Warp holder = new Warp();
		List<Warp> allWarps = new ArrayList<Warp>();
		Set<String> WarpNames;
		WarpNames = WarpData.getConfigurationSection("main").getKeys(false);
		int len = WarpNames.size();
		String[] Warps = WarpNames.toArray(new String[0]);
		for (int i = 0; i < len; i++){
			holder.setName(Warps[i]);
			holder.setWorld(WarpData.getString("main."+Warps[i]+".world"));
			holder.setX(WarpData.getInt("main."+Warps[i]+".X"));
			holder.setY(WarpData.getInt("main."+Warps[i]+".Y"));
			holder.setZ(WarpData.getInt("main."+Warps[i]+".Z"));
			allWarps.add(holder); 
			System.out.print("[Simple Warp]: " + Warps[i] + " loaded.");
		}
		//debug
		Warp debug = new Warp();
		debug.setName("spawn");
		debug.setWorld("Molivir_Hungergames");
		debug.setX(-104);
		debug.setY(36);
		debug.setZ(20);
		//debug
		if(allWarps.contains(debug.getName())){
			System.out.print("Warp is in the thing");
		}else{
			System.out.print("Warp is not in thing");
		}
		return allWarps;
	}
}

