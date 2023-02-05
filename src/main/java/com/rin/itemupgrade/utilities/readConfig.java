package com.rin.itemupgrade.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static net.Indyuce.mmoitems.MMOItems.plugin;

public class readConfig {
    public static YamlConfiguration loadMMOConfig(String file) {
        File configFile = new File(plugin.getDataFolder() + "/" + file);
        YamlConfiguration configs = new YamlConfiguration();
        try {
            configs.load(configFile);
            return configs;
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Unable to load config from MMOItem, Did you have MMOItems installed?");
            throw new RuntimeException(e);
        }
    }
    public static String getMMOPath() {
        return String.valueOf(new File(String.valueOf(plugin.getDataFolder())));
    }
}
