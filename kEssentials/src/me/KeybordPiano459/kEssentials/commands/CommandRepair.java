package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandRepair extends kCommand {
    public CommandRepair(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.repair")) {
                    ItemStack item = player.getItemInHand();
                    item.setDurability((short) 0);
                    player.sendMessage(GREEN + "Your item has been repaired!");
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/repair");
            }
        } else {
            consoleError();
        }
        return false;
    }
}