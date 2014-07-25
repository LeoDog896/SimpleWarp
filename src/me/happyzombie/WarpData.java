package me.happyzombie;

import java.io.File;
import org.bukkit.entity.Player;

public class WarpData {
	
	public static void testWarp(Player player, String args[]){
		File WarpDataFile = new File("plugins"+File.separator+"WarpMain"+File.separator+"Warps"+File.separator+args[1]+".yml");
		boolean cond = false;
		
		cond = WarpDataFile.exists();
		
		String str = Boolean.toString(cond);
		player.sendMessage(str);
	}
	

}

