package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandIp extends kCommand {
    public CommandIp(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kessentials.ip")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        player.sendMessage(GREEN + tplayer.getName() + "'s IP is " + tplayer.getAddress().getHostName());
                    } else {
                        player.sendMessage(RED + args[0] + " isn't currently online.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/ip <player>");
            }
        } else {
            if (args.length == 1) {
                Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                if (tplayer != null) {
                    log(Level.INFO, tplayer.getName() + "'s IP is " + tplayer.getAddress().getHostName());
                } else {
                    log(Level.INFO, args[0] + " isn't currently online.");
                }
            } else {
                incorrectUsageC("/ip <player>");
            }
        }
        return false;
    }
}