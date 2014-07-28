package me.happyzombie.SimpleWarpTests;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpCompassTest {
	
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
		FileConfiguration WarpData = null;
		File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+"warps.yml");
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
		WarpData = YamlConfiguration.loadConfiguration(WarpDataFile);
		if (WarpData.contains(args[1])){
			String name = (WarpData.getString(args[1] + ".world"));
			if (player.getWorld().getName().equals(name)){
				double x = (WarpData.getInt(args[1] + ".X")) + 0.5;
				double y = (WarpData.getInt(args[1] + ".Y")) + 0.5;
				double z = (WarpData.getInt(args[1] + ".Z")) + 0.5;

				Location warp = new Location(Bukkit.getServer().getWorld(name), x, y, z);
				player.setCompassTarget(warp);
				player.sendMessage(ChatColor.BLUE + "Your compass now points to warp " + args[1]);
			}else{
				player.sendMessage(ChatColor.RED + "Your compass cannot point to a warp in another world!");
			}
		}else{
			player.sendMessage(ChatColor.RED + "The specified warp does not exist.");
		}
	}
}
