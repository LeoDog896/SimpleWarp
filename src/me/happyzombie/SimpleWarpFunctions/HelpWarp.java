package me.happyzombie.SimpleWarpFunctions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpWarp {
	
	public static void help(Player player, String[] args){
		int len = args.length;
		if (len == 1){ 
			helpDefault(player);
			return;
		}else if(len == 2){
		switch(args[1]){
			case "set":
				helpSet(player);
				return;
			case "delete":
				helpDelete(player);
				return;
			case "to":
				helpTo(player);
				return;
			case "list":
				helpList(player);
				return;
			case "compass":
				helpCompass(player);
				return;
			default:
				player.sendMessage(ChatColor.RED + args[1] + " is not a command.");
					
		}
	}else{
		player.sendMessage(ChatColor.RED + "Invalid arguements");
	}
		
	}

	public static void helpDefault(Player player){
		player.sendMessage(ChatColor.GOLD +"This is the Simple Warp help!");
		player.sendMessage(ChatColor.GOLD +"---------------------------");
		player.sendMessage(ChatColor.GOLD +"/warp help [command] see detailed help.");
		player.sendMessage(ChatColor.GOLD +"/warp set [name] creates a warp with the specified name.");
		player.sendMessage(ChatColor.GOLD +"/warp delete [name] deletes the warp with that name.");
		player.sendMessage(ChatColor.GOLD +"/warp to [name] takes you to the specified warp.");
		player.sendMessage(ChatColor.GOLD +"/warp list lists all warps and their world.");
		player.sendMessage(ChatColor.GOLD +"/warp compass[name] sets your compass to point at a warp.");
	}
	
	public static void helpSet(Player player){
		player.sendMessage(ChatColor.GOLD + "Help for set.");
		player.sendMessage(ChatColor.GOLD +"---------------------------");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp set [name]");
		player.sendMessage(ChatColor.GOLD + "[Info]"+ChatColor.WHITE + "Creates a warp with the name specified.");
		player.sendMessage("Please note you cannot make multiple warps with the same names.");
	}
	
	public static void helpDelete(Player player){
		player.sendMessage(ChatColor.GOLD + "Help for delete.");
		player.sendMessage(ChatColor.GOLD +"---------------------------");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp delete [name]");
		player.sendMessage(ChatColor.GOLD + "[Info]"+ChatColor.WHITE + "Deletes the specified warp.");
	}
	
	public static void helpTo(Player player){
		player.sendMessage(ChatColor.GOLD + "Help for set.");
		player.sendMessage(ChatColor.GOLD +"---------------------------");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp to [name]");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp to [name] [player]");
		player.sendMessage(ChatColor.GOLD + "[Info]"+ChatColor.WHITE + "If no name specified, it takes you to the chosen warp.");
		player.sendMessage("If you chose to input a name it will warp the specified player.");
	}
	
	public static void helpList(Player player){
		player.sendMessage(ChatColor.GOLD + "Help for list.");
		player.sendMessage(ChatColor.GOLD +"---------------------------");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp list");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp list [world]");
		player.sendMessage(ChatColor.GOLD + "[Info]"+ChatColor.WHITE + "If no world specified it will list all the warps.");
		player.sendMessage("If a world is specified it will list all warps in that world");
	}
	
	public static void helpCompass(Player player){
		player.sendMessage(ChatColor.GOLD + "Help for compass.");
		player.sendMessage(ChatColor.GOLD +"---------------------------");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp compass");
		player.sendMessage(ChatColor.GOLD + "[Usage]"+ChatColor.WHITE + "/warp list [name]");
		player.sendMessage(ChatColor.GOLD + "[Info]"+ChatColor.WHITE + "If no warp specified the compass with reset to default.");
		player.sendMessage("Else if a warp is specified the compass will point to it.");
	}
}
