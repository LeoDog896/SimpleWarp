package me.happyzombie.SimpleWarpFunctions;

import java.util.List;

import me.happyzombie.Objects.Warp;

import org.bukkit.entity.Player;

public class GotoList {

	public static void gotoList(Player player, String args[], List<Warp> warps){
		//debugging shit, delete later
		Warp debug = new Warp();
		debug.setName("spawn");
		warps.add(debug);
		//end of debug
		args[1].toLowerCase();
		Warp test = new Warp();
		test.setName(args[1]);
		if(warps.contains(test.findName(args[1]))){
			player.sendMessage("Warp found");
		}else{
			player.sendMessage("Warp not found");
		}
	}
}
