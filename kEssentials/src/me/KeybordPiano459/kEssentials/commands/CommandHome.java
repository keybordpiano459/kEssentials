package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHome extends kCommand {
    public CommandHome(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.home")) {
                    kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
                    if (kplayer.getPlayerConfig().getConfig().getString("home.world") != null) {
                        World world = Bukkit.getServer().getWorld(kplayer.getPlayerConfig().getConfig().getString("home.world"));
                        double x = kplayer.getPlayerConfig().getConfig().getInt("home.x");
                        double y = kplayer.getPlayerConfig().getConfig().getInt("home.y");
                        double z = kplayer.getPlayerConfig().getConfig().getInt("home.z");
                        float yaw = kplayer.getPlayerConfig().getConfig().getInt("home.yaw");
                        float pitch = kplayer.getPlayerConfig().getConfig().getInt("home.pitch");
                        Location home = new Location(world, x, y, z, yaw, pitch);
                        player.teleport(home);
                        player.sendMessage(GREEN + "You have been sent home!");
                    } else {
                        player.sendMessage(RED + "You haven't set a home yet!");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/home");
            }
        } else {
            consoleError();
        }
        return false;
    }
}