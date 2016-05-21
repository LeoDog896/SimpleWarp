package org.happyzombie.WarpFunctions;

import org.happyzombie.WarpMain;

public class BeaconWarp {

	public static boolean showBeacon(WarpMain plugin, String args[]){
		String warpName = args[1];
		plugin.getLogger().info(plugin.warps.get(warpName).getName());
		plugin.getLogger().info(plugin.warps.get(warpName).getWorldID().toString());
		plugin.getLogger().info(""+plugin.warps.get(warpName).getX());
		plugin.getLogger().info(""+plugin.warps.get(warpName).getY());
		plugin.getLogger().info(""+plugin.warps.get(warpName).getZ());
		return true;
	}
	
}
