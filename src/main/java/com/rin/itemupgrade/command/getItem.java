package com.rin.itemupgrade.command;

import com.rin.itemupgrade.handler.itemhandler;
import com.rin.itemupgrade.utilities.readConfig;
import io.lumine.mythic.lib.api.util.SmartGive;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class getItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack i = itemhandler.GetMMOItem("SWORD","CUTLASS");
            new SmartGive(p).give(i);
        } else {
            // for debugging in console
            if (Objects.equals(args[0], "console")) {
                String asd = readConfig.getMMOPath();
                Bukkit.getConsoleSender().sendMessage(asd);
            }
        }
        return false;
    }
}
