/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          Any use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.E;

import java.util.HashMap;

import me.ultimate.E.ChatManager.ChatListener;
import me.ultimate.Events.EventCOD;
import me.ultimate.Events.EventCTF;
import me.ultimate.Events.EventHalo;
import me.ultimate.Events.EventMobArena;
import me.ultimate.Events.EventPaintball;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.earth2me.essentials.Essentials;

public class Events extends JavaPlugin {

    Location loc;
    BukkitTask Timer;
    HashMap<Player, String> playerEvent = new HashMap<Player, String>();
    EventsMethods Utils = new EventsMethods();

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        Timer = new Timer(this).runTaskTimer(this, 1, 1);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new EventsListener(this), this);
        saveConfig();
        Utils.registerEvent(new EventMobArena());
        Utils.registerEvent(new EventPaintball());
        Utils.registerEvent(new EventCOD());
        Utils.registerEvent(new EventCTF());
        Utils.registerEvent(new EventHalo());
    }

    @Override
    public void onDisable() {
        cancelTimers();
    }

    public void log(String logMsg) {
        getLogger().info(logMsg);
    }

    public EventsMethods getUtil() {
        return new EventsMethods();
    }

    public EventMobArena getMA() {
        return new EventMobArena();
    }

    public Essentials getEssentials() {
        return (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
    }

    public void cancelTimers() {
        Timer.cancel();
    }
}
