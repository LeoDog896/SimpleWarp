package me.happyzombie.SimpleWarpTests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
		if (WarpData.contains(args[1])){
			String name = (WarpData.getString(args[1]));
			String world = (WarpData.getString(args[1] + ".world"));
			double x = (WarpData.getInt(args[1] + ".X"));
			double y = (WarpData.getInt(args[1] + ".Y"));
			double z = (WarpData.getInt(args[1] + ".Z"));
			holder.setName(name);
			holder.setWorld(world);
			holder.setX(x);
			holder.setY(y);
			holder.setZ(z);
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
		player.sendMessage(holder.getName());
		return;
	}
}
