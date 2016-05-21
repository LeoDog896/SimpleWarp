package org.happyzombie.Objects;

import java.util.UUID;

import org.bukkit.Location;
import org.happyzombie.WarpMain;

public class Warp {
	
	private String name;
	private String world;
	private UUID worldID;
	private double x;
	private double y;
	private double z;
	
	//Constructors
	public Warp(){}
	
	public Warp(String name, Location location){
		this.name = name;
		this.worldID = location.getWorld().getUID();
		this.x = Math.floor(location.getX());
		this.y = Math.floor(location.getY());
		this.z = Math.floor(location.getZ());
	}
	
	//Getters & setters
	//------Name----------
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	//------World---------
	public String getWorld() {return world;}
	public void setWorld(String world) {this.world = world;}
	//------World ID------
	public UUID getWorldID() {return this.worldID;}
	public String getWorld(WarpMain plugin){ return plugin.getServer().getWorld(worldID).getName();}
	public void setWorldID(String id){worldID = UUID.fromString(id);}
	public void setWorldID(UUID id){worldID = id;}
	//------X-------------
	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	//------Y-------------
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}
	//------Z-------------
	public double getZ() {return z;}
	public void setZ(double z) {this.z = z;}
	//------END-----------

	//Return Location object for warp
	public Location getLocation(WarpMain plugin){
		return new Location(plugin.getServer().getWorld(worldID),x,y,z);
	}
	
}
