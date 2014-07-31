package me.happyzombie.Commands;
 
import java.util.ArrayList;
import java.util.List;

import me.happyzombie.Objects.Warp;
import me.happyzombie.SimpleWarpFunctions.CreateWarpTest;
import me.happyzombie.SimpleWarpFunctions.DeleteWarpTest;
import me.happyzombie.SimpleWarpFunctions.GotoList;
import me.happyzombie.SimpleWarpFunctions.GotoWarpTest;
import me.happyzombie.SimpleWarpFunctions.HelpWarp;
import me.happyzombie.SimpleWarpFunctions.ListWarpTest;
import me.happyzombie.SimpleWarpFunctions.WarpCompassTest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
 
public class CommandHandler implements CommandExecutor {
	
	private final Plugin plugin;
	List<Warp> warpList = new ArrayList<Warp>();
 
	public CommandHandler(Plugin plugin, List<Warp> warps) {
		this.plugin = plugin;
		warpList = warps;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player){
			
			if (cmd.getName().equalsIgnoreCase("warp")) {
				int len = args.length;
				switch (args[0].toLowerCase()){
				case "help":
					HelpWarp.help(player, args);
					return true;
				case "set":
					CreateWarpTest.create(player, args);
					return true;
				case "delete":
					DeleteWarpTest.delete(player, args);
					return true;
				case "to":
					GotoWarpTest.gotoWarp(player, args);
					return true;
				case "list":
					ListWarpTest.listWarps(player, args);
					return true;
				case "gototest":
					GotoList.gotoList(player, args, warpList);
					return true;
				case "compass":
					len = args.length;
					if (len == 1){
						WarpCompassTest.compassDefault(player, args);
						return true;
					}
					WarpCompassTest.compassSet(player, args);
					return true;
				default: 
					player.sendMessage(ChatColor.RED + args[0] + " is not a command.");
					return false;
				}
			}
		}
		return false;
	}
}