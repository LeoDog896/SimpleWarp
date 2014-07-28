package me.happyzombie;

import java.io.File;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
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
		this.getCommand("warp").setExecutor(new CommandHandler(this));
		File WarpDir = new File ("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+getServer().getWorlds().get(0).getName()+File.separator);
		if(!WarpDir.exists()){
			WarpDir.mkdirs();
			getLogger().info("Warp folder for "+ getServer().getWorlds().get(0).getName() +" created!");
		}

	}
	
	@Override
	public void onDisable() {
		getLogger().info("Shutting down warps");
	}
	

}