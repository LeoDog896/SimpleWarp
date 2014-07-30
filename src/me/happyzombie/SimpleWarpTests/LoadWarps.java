package me.happyzombie.SimpleWarpTests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.happyzombie.Warp;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class LoadWarps {
	
	static List<Warp> warps = new ArrayList<Warp>();
	
	public static void load(Player player, String args[]){
		Warp holder = new Warp();
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
		if (WarpData.contains("main."+args[1])){
			String name = (WarpData.getString("main."+args[1]));
			String world = (WarpData.getString(args[1] + ".world"));
			double x = (WarpData.getInt("main."+args[1] + ".X"));
			double y = (WarpData.getInt("main."+args[1] + ".Y"));
			double z = (WarpData.getInt("main."+args[1] + ".Z"));
			holder.setName(name);
			holder.setWorld(world);
			holder.setX(x);
			holder.setY(y);
			holder.setZ(z);
			warps.add(holder);
		if (warps.add(holder)){
			player.sendMessage("Warp loaded");
		}else{
			player.sendMessage("Loading failed");
		}
		}else{
			player.sendMessage(ChatColor.RED + "Specified warp does not exist.");
		}
	}
	
	public static void getWarpName(Player player, String args[]){
		int index = 1;
		Warp holder = new Warp();
		holder = warps.get(index);
		String WarpName = holder.getName();
		player.sendMessage(WarpName);
		return;
	}
	public static void clearWarpList(Player player){
		warps.clear();
		player.sendMessage("Warp list cleared");
		return;
	}
	
	public static void loadAllWarps(){
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
	}
}

