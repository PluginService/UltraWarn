package me.LiamPlugins;

import java.util.logging.Level;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraWarn extends JavaPlugin implements Listener
{
    int warnCount = 0;
    boolean warn = false;
    
    @Override
    public void onEnable() 
    {
        getLogger().info("[UltraWarn] Has been enabled (V1.0.0)");
    }

    @Override
    public void onDisable() 
    {
        getLogger().info("[UltraWarn] Has been disabled (V1.0.0)");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        FileConfiguration config = this.getConfig();
        
        if (cmd.getName().equalsIgnoreCase("warn"))
        {
            if (args.length >= 2)
            {
                config.addDefault("","" + " - " + sender.getName());
            }
              else
              {
              sender.sendMessage(ChatColor.RED + "Syntax Error! " + ChatColor.GRAY + "Do /warn <player> <reason>");
              }
        }
        return true;
    }
    
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player p = event.getPlayer();
        String pName = p.getName();
        String message = event.getMessage();
        String messageTrim = event.getMessage().trim();
        if (messageTrim.matches(message))
        {
            event.getPlayer().sendMessage(ChatColor.RED + "Error!" + ChatColor.GRAY + " There has been an error in the code please report this use the tag #192 to address this issue!");
        }
        if (p.isOnline() && warn == true && !p.isOp())
        {
        
        }
    }
}
