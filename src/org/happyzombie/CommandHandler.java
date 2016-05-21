package org.happyzombie;
 
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.happyzombie.Objects.Warp;
import org.happyzombie.WarpFunctions.BeaconWarp;
import org.happyzombie.WarpFunctions.CreateWarp;
import org.happyzombie.WarpFunctions.DeleteWarp;
import org.happyzombie.WarpFunctions.GotoWarp;
import org.happyzombie.WarpFunctions.HelpWarp;
import org.happyzombie.WarpFunctions.InfoWarp;
import org.happyzombie.WarpFunctions.ListWarp;
import org.happyzombie.WarpFunctions.SaveWarps;
import org.happyzombie.WarpFunctions.WarpCompass;
 
@SuppressWarnings("unused")
public class CommandHandler implements CommandExecutor {
	
	private final WarpMain plugin;
	List<Warp> warpList = new ArrayList<Warp>();
 
	public CommandHandler(WarpMain plugin) {
		this.plugin = plugin;
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
					CreateWarp.create(player, plugin, args);
					return true;
				case "delete":
					DeleteWarp.delete(player, plugin, args);
					return true;
				case "to":
					GotoWarp.gotoWarp(player, plugin, args);
					return true;
				case "list":
					ListWarp.listWarps(player, plugin, args);
					return true;
				case "info":
					return InfoWarp.warpInfo(player, plugin, args);
				case "save":
					return SaveWarps.saveWarps(player, plugin);
				case "beacon":
					return BeaconWarp.showBeacon(plugin, args);
				case "compass":
					len = args.length;
					if (len == 1){
						WarpCompass.compassDefault(player, plugin, args);
						return true;
					}
					WarpCompass.compassSet(player, plugin, args);
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