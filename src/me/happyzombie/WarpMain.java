package me.happyzombie;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;


public class WarpMain extends JavaPlugin {
	
	public Permission warpSet = new Permission("simpleWarp.set");
	public Permission warpDelete = new Permission("simpleWarp.delete");
	public Permission warpGoto = new Permission("simpleWarp.goto");
	public Permission warpGotoOther = new Permission("simpleWarp.goto.other");
	public Permission warpCompass = new Permission("simpleWarp.compass");
	public Permission warpBeacon = new Permission("simpleWarp.beacon");
	public Permission warpList = new Permission("simpleWarp.list");
	public Permission warpManual = new Permission("simpleWarp.manual");
	public Permission warpRandom = new Permission("simpleWarp.random");
	
	@Override
	public void onEnable() {
		getLogger().info("WarpMain 1.0 enabled!");
		File WarpDir = new File ("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+getServer().getWorlds().get(0).getName()+File.separator);
		if(!WarpDir.exists()){
			WarpDir.mkdirs();
			getLogger().info("Warp folder for "+ getServer().getWorlds().get(0).getName() +" created!");
		}
		PluginManager pm = getServer().getPluginManager();
		pm.getPermission("warpSet");
		pm.getPermission("warpDelete");
		pm.getPermission("warpGoto");
		pm.getPermission("warpGotoOther");
		pm.getPermission("warpCompass");
		pm.getPermission("warpBeacon");
		pm.getPermission("warpList");
		pm.getPermission("warpManual");
		pm.getPermission("warpRandom");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Shutting down warps");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		new ListenerClass(this);
		Player player = (Player) sender;
		int len = 0;
		
		if (cmd.getName().equalsIgnoreCase("warp") && sender instanceof Player){
			
			if (args[0].equalsIgnoreCase("set")){
				if (sender.hasPermission(warpSet)){
					WarpCreate.createWarpFile(player, args);
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
					return true;
				}
			}else if (args[0].equalsIgnoreCase("help")){
				player.sendMessage(ChatColor.GOLD +"This is the Simple Warp help!");
				player.sendMessage(ChatColor.GOLD +"---------------------------");
				player.sendMessage(ChatColor.GOLD +"/warp set [name] - creates a warp with the specified name.");
				player.sendMessage(ChatColor.GOLD +"/warp delete [name] - deletes the warp with that name.");
				player.sendMessage(ChatColor.GOLD +"/warp to [name] - takes you to the specified warp.");
				player.sendMessage(ChatColor.GOLD +"/warp list - lists all warps in the current world.");
				return true;
			}else if (args[0].equalsIgnoreCase("to")){
				WarpGoto.gotoWarp(player, args);
				return true;
			}else if (args[0].equalsIgnoreCase("delete")){
				if (sender.hasPermission(warpDelete)){
					WarpDelete.deleteWarpFile(player, args);
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
					return true;
				}
			}else if (args[0].equalsIgnoreCase("list")){
				if (sender.hasPermission(warpList)){
					WarpList.listWarps(player, args);
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
					return true;
				}
			}else if (args[0].equalsIgnoreCase("beacon")){
				if (sender.hasPermission(warpBeacon)){
					player.sendMessage("coming soon!");
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
				}
			}else if (args[0].equalsIgnoreCase("compass")){
					len = args.length;
					if (len == 1){
						WarpCompass.compassDefault(player, args);
						return true;
					}
					WarpCompass.compassSet(player, args);
					return true;
			}else{
				sender.sendMessage(ChatColor.RED + args[1] +" Is not a command, try /warp help for help.");
				return false;
			}
		}
		
		return false;
	}
}