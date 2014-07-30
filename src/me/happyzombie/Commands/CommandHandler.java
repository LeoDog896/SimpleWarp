package me.happyzombie.Commands;
 
import me.happyzombie.SimpleWarpTests.CreateWarpTest;
import me.happyzombie.SimpleWarpTests.DeleteWarpTest;
import me.happyzombie.SimpleWarpTests.GotoWarpTest;
import me.happyzombie.SimpleWarpTests.ListWarpTest;
import me.happyzombie.SimpleWarpTests.LoadWarps;
import me.happyzombie.SimpleWarpTests.WarpCompassTest;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
 
public class CommandHandler implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private final Plugin plugin;
 
	public CommandHandler(Plugin plugin) {
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
					player.sendMessage(ChatColor.GOLD +"This is the Simple Warp help!");
					player.sendMessage(ChatColor.GOLD +"---------------------------");
					player.sendMessage(ChatColor.GOLD +"/warp set [name] - creates a warp with the specified name.");
					player.sendMessage(ChatColor.GOLD +"/warp delete [name] - deletes the warp with that name.");
					player.sendMessage(ChatColor.GOLD +"/warp to [name] - takes you to the specified warp.");
					player.sendMessage(ChatColor.GOLD +"/warp list - lists all warps in the current world.");
					return true;
				case "load":
					LoadWarps.load(player, args);
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
				case "get":
					LoadWarps.getWarpName(player, args);
					return true;
				case "clear":
					LoadWarps.clearWarpList(player);
					return true;
				case "list":
					ListWarpTest.listWarps(player, args);
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