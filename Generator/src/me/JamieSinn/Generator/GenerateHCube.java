package me.JamieSinn.Generator;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GenerateHCube extends Generator
{	
	public void generateHCube(Location point, int length)
	{  
		World world = point.getWorld();

		int x_start = point.getBlockX();     
		int y_start = point.getBlockY();    
		int z_start = point.getBlockZ();

		int x_length = x_start + length;    
		int y_length = y_start + length;
		int z_length = z_start + length;

			for(int x_operate = x_start; x_operate <= x_length; x_operate++)
			{ 
				for(int y_operate = y_start; y_operate <= y_length; y_operate++)
				{
					for(int z_operate = z_start; z_operate <= z_length; z_operate++)
					{
						Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate); 
						blockToChange.setTypeId(getConfig().getInt("hcubeMat"));    				
					}
	
				}

			}
	        
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		if(commandLabel.equalsIgnoreCase("ghcube"))
		{
	
			int length = getConfig().getInt("hcubeL");
			Location point = player.getLocation();
			this.generateHCube(point, length);
			player.sendMessage(Prefix + Text + ChatColor.RED + "Cube");
		}
		return false;
	}
}
