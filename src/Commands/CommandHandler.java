package Commands;
 
import me.happyzombie.WarpCompass;
import me.happyzombie.WarpCreate;
import me.happyzombie.WarpDelete;
import me.happyzombie.WarpList;
import me.happyzombie.SimpleWarpTests.CreateWarpTest;
import me.happyzombie.SimpleWarpTests.DeleteWarpTest;
import me.happyzombie.SimpleWarpTests.GotoWarpTest;
import me.happyzombie.SimpleWarpTests.LoadWarps;
import me.happyzombie.SimpleWarpTests.WarpCompassTest;
import me.happyzombie.go_to.WarpGoto;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
 
public class CommandHandler implements CommandExecutor {
 
	private final Plugin plugin;
 
	public CommandHandler(Plugin plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		player.sendMessage("i's all workin' good");
		if (sender instanceof Player){
			
			if (cmd.getName().equalsIgnoreCase("test")) {
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
				case "set":
						WarpCreate.createWarpFile(player, args);
						return true;
				case "to":
					WarpGoto.gotoWarp(player, args);
					return true;
				case "test":
					LoadWarps.load(player, args);
					return true;
				case "delete":
					WarpDelete.deleteWarpFile(player, args);
					return true;
				case "list":
					WarpList.listWarps(player, args);
					return true;
				case "beacon":
					player.sendMessage("coming soon!");
					return true;
				case "testcreate":
					CreateWarpTest.create(player, args);
					return true;
				case "testdelete":
					DeleteWarpTest.delete(player, args);
					return true;
				case "testgoto":
					GotoWarpTest.gotoWarp(player, args);
					return true;
				case "getwarp":
					LoadWarps.getWarpName(player, args);
					return true;
				case "testcompass":
					len = args.length;
					if (len == 1){
						WarpCompassTest.compassDefault(player, args);
						return true;
					}
					WarpCompassTest.compassSet(player, args);
					return true;
				case "compass":
					len = args.length;
					if (len == 1){
						WarpCompass.compassDefault(player, args);
						return true;
					}
					WarpCompass.compassSet(player, args);
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