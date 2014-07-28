package me.happyzombie;

import java.io.File;

import me.happyzombie.SimpleWarpTests.CreateWarpTest;
import me.happyzombie.SimpleWarpTests.DeleteWarpTest;
import me.happyzombie.SimpleWarpTests.GotoWarpTest;
import me.happyzombie.SimpleWarpTests.LoadWarps;
import me.happyzombie.SimpleWarpTests.WarpCompassTest;
import me.happyzombie.go_to.WarpGoto;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

import Commands.CommandHandler;


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
		this.getCommand("test").setExecutor(new CommandHandler(this));
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
	

}