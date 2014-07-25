package me.happyzombie;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpCompass {
	
	public static void compassDefault(Player player, String args[]){
		Location spawn = new Location(null, 0, 0, 0);
		
		if (player.getBedSpawnLocation() == null){
			spawn = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();
		}else{
			spawn = player.getBedSpawnLocation();
		}
		player.setCompassTarget(spawn);
	}
	
	public static void compassSet(Player player, String args[]){
		Location warp = new Location(null, 0, 0, 0);
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName()+File.separator+args[1]+".yml");
		if (!WarpDataFile.exists()){
			player.sendMessage(ChatColor.RED + "The specified warp does not exist.");
			return;
		}
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
		
		double x = (WarpData.getInt("Warp.X"));
		double y = (WarpData.getInt("Warp.Y"));
		double z = (WarpData.getInt("Warp.Z"));
		
		warp = new Location(player.getWorld(), x, y, z);
		
		player.setCompassTarget(warp);
		
		player.sendMessage(ChatColor.BLUE + "Your compass now points to warp " + args[1]);
	}
}
