package org.happyzombie;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

public class DataManager {

	public static void saveConfig(FileConfiguration config, File file){
	    try { 
	    	config.save(file);
	    } catch (IOException e) { 
	    	e.printStackTrace(); 
	    }
	}

}