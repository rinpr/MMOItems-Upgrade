package com.rin.itemupgrade.command;

import com.rin.itemupgrade.handler.itemhandler;
import com.rin.itemupgrade.utilities.readConfig;
import net.Indyuce.mmoitems.api.UpgradeTemplate;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class upgradeItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack hand = p.getInventory().getItemInMainHand();
            //MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "CUTLASS")
            if (hand.getType() != Material.AIR && itemhandler.IsMMO(hand)) {
                YamlConfiguration configs = readConfig.loadMMOConfig("upgrade-templates.yml");

                for (Object string : configs.getConfigurationSection("weapon-default").getKeys(false).toArray()) {
                    p.sendMessage(String.valueOf(string));
                }
                UpgradeTemplate upTemp = new UpgradeTemplate(Objects.requireNonNull(configs.getConfigurationSection("weapon-default")));
//                upTemp.upgrade(Objects.requireNonNull(new MMOItems().getMMOItem(MMOItems.plugin.getTypes().get("SWORD"), "CUTLASS")));

//                p.getInventory().remove(hand);
//                new SmartGive(p).give(upgraded);
                p.sendMessage("You are holding an MMOItems");
            }
        }
        return false;
    }
}
