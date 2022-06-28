package io.github.lamberkeep.serverinfo.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.Random;

import static io.github.lamberkeep.serverinfo.ServerInfo.*;

public class ServerListPingEvent implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onPing(org.bukkit.event.server.ServerListPingEvent event) {
        List<?> motds = config.getList("motds");
        assert motds != null;

        String motd = ChatColor.translateAlternateColorCodes('&', (String) motds.get(random.nextInt(motds.size())));

        event.setMotd(motd);
    }
}
