package me.ultimate.E;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Events extends JavaPlugin {

    Location loc;
    String eventName;
    BukkitTask Scoreboard;

    public void onEnable() {
        Scoreboard = new Scoreboard(this).runTaskTimer(this, 20, 20);
    }

    String t(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public void onDisable() {
        Scoreboard.cancel();
    }
}
