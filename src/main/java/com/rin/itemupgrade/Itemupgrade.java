package com.rin.itemupgrade;

import com.rin.itemupgrade.command.getItem;
import com.rin.itemupgrade.command.upgradeItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class Itemupgrade extends JavaPlugin {
    public static Itemupgrade plugin;
    public Itemupgrade() {
        plugin = this;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "The plugin has started!");
        this.getLogger().log(Level.INFO,"The plugin has started");
        registerCommand();
    }
    private void registerCommand() {
        Objects.requireNonNull(this.getCommand("getitem")).setExecutor(new getItem());
        Objects.requireNonNull(this.getCommand("upgradeitem")).setExecutor(new upgradeItem());
    }
    public String getPrefix() {
        return ChatColor.DARK_GRAY + "[" + ChatColor.LIGHT_PURPLE + "ItemUpgrade" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Shutting down plugin...");
        this.getLogger().log(Level.INFO,"Shutting down plugin...");
    }
}
