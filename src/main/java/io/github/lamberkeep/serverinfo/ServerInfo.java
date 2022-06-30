package io.github.lamberkeep.serverinfo;

import io.github.lamberkeep.serverinfo.listener.ServerListPingEvent;
import io.github.lamberkeep.serverinfo.task.ChatMessages;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class ServerInfo extends JavaPlugin {

    public static ServerInfo plugin;
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        plugin = this;

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ServerListPingEvent(), this);

        saveDefaultConfig();
        config = getConfig();

        if (config.getBoolean("messages.enabled")) {new ChatMessages();}

        Bukkit.getLogger().log(Level.INFO, "I'm ready!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.INFO, "Bye!");
    }
}
