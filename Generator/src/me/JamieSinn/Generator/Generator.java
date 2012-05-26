package me.JamieSinn.Generator;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Generator extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Generator Plugin;
	
	public final PlayerListener pl = new PlayerListener();
	public final GenerateCube gc = new GenerateCube();
	public final GenerateBuilding gb = new GenerateBuilding();
	public final GenerateStructures gs = new GenerateStructures();
	
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Disabled");
	}
		public void onEnable()
		{
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Has Been Successfully Enabled!");
		}
			public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
			{
				Player player = null;
				if (sender instanceof Player) {
					player = (Player) sender;
				}
				if(commandLabel.equalsIgnoreCase("gcube"))
				{
					int length = getConfig().getInt("cubeL");
					Location point = player.getLocation();
					this.generateCube(point, length);
					this.getConfig().options().copyDefaults(true);
			        this.saveConfig();
				}
				return false;
			}
			public void generateCube(Location point, int length)
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
					blockToChange.setTypeId(getConfig().getInt("cubeMat"));    				
					}
			}
		}
			        
}
}
