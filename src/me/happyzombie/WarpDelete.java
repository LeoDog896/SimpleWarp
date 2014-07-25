package me.happyzombie;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WarpDelete {

	public static void deleteWarpFile(Player player, String args[]){
		
		if (args.length == 1){
			player.sendMessage(ChatColor.RED + "Please specify a world.");
			return;
		}else if(args.length == 2){
			File WarpDataFile = new File("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName()+File.separator+args[1]+".yml");
			if (WarpDataFile.exists()){
				WarpDataFile.delete();
				player.sendMessage(ChatColor.GREEN + "The warp " + args[1] + " was deleted!");
			}else{
				player.sendMessage(ChatColor.RED + "The warp " +args[1] + " doesn't exist.");
			}
		
		}else{
			player.sendMessage("Too many arguements");
		}
	}
}