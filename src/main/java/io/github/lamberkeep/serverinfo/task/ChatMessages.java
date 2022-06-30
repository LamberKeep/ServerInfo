package io.github.lamberkeep.serverinfo.task;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Random;

import static io.github.lamberkeep.serverinfo.ServerInfo.config;
import static io.github.lamberkeep.serverinfo.ServerInfo.plugin;

public class ChatMessages implements Runnable {

    private final Random random = new Random();

    public ChatMessages() {
        Bukkit.getScheduler().runTaskTimer(plugin, this, 0, config.getLong("messages.delay") * 1200);
    }

    @Override
    public void run() {
        List<?> messages = config.getList("messages.list");
        assert messages != null;

        String message = ChatColor.translateAlternateColorCodes('&', (String) messages.get(random.nextInt(messages.size())));

        plugin.getServer().broadcastMessage(message);
    }
}
