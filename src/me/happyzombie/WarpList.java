package me.happyzombie;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WarpList {

	public static void listWarps (Player player, String args[]){
		  int argLength = args.length;
		  String path = null;
		  if (argLength == 1){
			  path = ("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+player.getWorld().getName());
			  File Check = new File(path);
			  if (!Check.exists()){
					player.sendMessage(ChatColor.RED + "World " + player.getWorld().getName() + " not found.");
				  return;
				}
			  player.sendMessage(ChatColor.BLUE + "List of all warps  in world " + player.getWorld().getName() +":");
		  }else if (argLength == 2){
			  path = ("plugins"+File.separator+"SimpleWarp"+File.separator+"Warps"+File.separator+args[1]);
			  
			  File Check = new File(path);
			  if (!Check.exists()){
					player.sendMessage(ChatColor.RED + "World " + args[1] + " not found.");
				  return;
				}
			  player.sendMessage(ChatColor.BLUE + "List of all warps  in world " + args[1] +":");
		  }else{
			  player.sendMessage(ChatColor.RED + "Invalid arguements.");
			  return;
		  }
		  String files;
		  int length;
		  File folder = new File(path);
		  if (!folder.exists()){return;}
		  File[] listOfFiles = folder.listFiles(); 
		  
		  for (int i = 0; i < listOfFiles.length; i++){
			  if (listOfFiles[i].isFile()) {
				  files = listOfFiles[i].getName();
				  length = files.length();
				  player.sendMessage(ChatColor.BLUE + files.substring(0,length-4));
		      }
		  }
	}
}