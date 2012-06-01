package me.JamieSinn.Generator;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Generator extends JavaPlugin
{
	String Prefix;
	String Text;
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Generator Plugin;
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Disabled");
	}
		public void onEnable()
		{
			Prefix = (ChatColor.GOLD + "[Generator]");
			Text = (ChatColor.BLUE + "Generated:");
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Has Been Successfully Enabled!");


		}


}
