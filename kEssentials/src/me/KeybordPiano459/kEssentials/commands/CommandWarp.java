package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandWarp extends kCommand {
    public CommandWarp(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kessentials.warp")) {
                    if (plugin.getWarps().getWarpsConfig().getString("warps." + args[0] + ".world") != null) {
                        String name = args[0];
                        FileConfiguration wconfig = plugin.getWarps().getWarpsConfig();
                        int x = wconfig.getInt("warps." + name + ".x");
                        int y = wconfig.getInt("warps." + name + ".y");
                        int z = wconfig.getInt("warps." + name + ".z");
                        float yaw = wconfig.getInt("warps." + name + ".yaw");
                        float pitch = wconfig.getInt("warps." + name + ".pitch");
                        String world = wconfig.getString("warps." + name + ".world");
                        World warpworld = Bukkit.getServer().getWorld(world);
                        Location warp = new Location(warpworld, x, y, z, yaw, pitch);
                        player.teleport(warp);
                        player.sendMessage(GREEN + "You have teleported to the warp " + YELLOW + name);
                    } else {
                        player.sendMessage(RED + "That warp doesn't exist.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/warp <name>");
            }
        } else {
            consoleError();
        }
        return false;
    }
}