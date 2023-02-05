package com.rin.itemupgrade;

import com.rin.itemupgrade.command.getItem;
import com.rin.itemupgrade.command.upgradeItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Itemupgrade extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "The plugin has started!");
        Objects.requireNonNull(this.getCommand("getitem")).setExecutor(new getItem());
        Objects.requireNonNull(this.getCommand("upgradeitem")).setExecutor(new upgradeItem());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Shutting down plugin...");
    }
}
