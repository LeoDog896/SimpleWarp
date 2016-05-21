package org.happyzombie.WarpFunctions;

import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.happyzombie.WarpMain;
import org.happyzombie.Objects.Warp;

public class ListWarp {
	
	public static void listWarps(Player player, WarpMain plugin, String args[]){
	
		//All warps in all worlds.
		if (args.length == 1){
			player.sendMessage(ChatColor.BLUE + "List of warps in all worlds.");
			for (Entry<String, Warp> w : plugin.warps.entrySet()){
				player.sendMessage(ChatColor.BLUE + w.getKey() + " --- " +w.getValue().getWorld(plugin));
			}
		}
		
		//All warps in user specified world.	
		else if(args.length == 2){
			String world = args[1];
			boolean found = false;
			
			player.sendMessage(ChatColor.BLUE + "List of warps in world: " + world);
			for (Entry<String, Warp> w : plugin.warps.entrySet()){
				if(world.equals(w.getValue().getWorld())){ //If warp world is same as specified world
					player.sendMessage(ChatColor.BLUE + w.getKey() + " --- " +w.getValue().getWorld(plugin));
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


