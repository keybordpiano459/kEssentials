package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandIgnite extends kCommand {
    public CommandIgnite(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.ignite")) {
                    player.setFireTicks(200);
                    player.sendMessage(GREEN + "You have been ignited!");
                } else {
                    noPermissionsMessage(player);
                }
            } else if (args.length == 1) {
                if (player.hasPermission("kessentials.ignite")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        tplayer.setFireTicks(200);
                        tplayer.sendMessage(DARK_GRAY + "You have been ignited!");
                        player.sendMessage(GREEN + "You have ignited " + tplayer.getName());
                    } else {
                        player.sendMessage(RED + args[0] + " is offline.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            }
        } else {
            if (args.length == 1) {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (player != null) {
                    player.setFireTicks(200);
                    player.sendMessage(DARK_GRAY + "You have been ignited!");
                    log(Level.INFO, "You have ignited " + player.getName());
                } else {
                    log(Level.INFO, args[0] + " is offline.");
                }
            } else {
                incorrectUsageC("/ignite <player>");
            }
        }
        return false;
    }
}