/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          Any use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.E;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EventsMethods {

    //QUICK NOTE!: If it is asking for a string in a method related to a player, it is asking for his name. Not his display name, p.getName()
    Events Events = new Events();
    @SuppressWarnings("unused")
    private final JavaPlugin plugin;
    String currentEvent;

    public EventsMethods(final JavaPlugin plugin) {
        this.plugin = plugin;
    }

    int eventNum;

    public void preEvent() {
        currentEvent = "MobArena";
    }

    public void startEvent() {
        final List<Player> players = new ArrayList<Player>();
        for (final Player p : Bukkit.getOnlinePlayers())
            if (!this.isPlayerInEvent(p))
                players.add(p);
        if (eventNum == 1)
            Events.getMA().onStart(players);
    }

    public List<String> playersInEvent(final String event) {
        final List<String> playersInEvent = new ArrayList<String>();
        for (final Player player : Bukkit.getOnlinePlayers())
            if (Events.playerEvent.containsKey(player.getName()))
                playersInEvent.add(player.getName());
        return playersInEvent;
    }

    public boolean removePlayerFromEvent(final String name) {
        if (Events.playerEvent.containsKey(name)) {
            Events.playerEvent.remove(name);
            return true;
        }
        return false;
    }

    public Boolean isPlayerInEvent(final Player p) {
        if (Events.playerEvent.containsKey(p.getName()))
            return true;
        return false;
    }

    public String getEventByPlayer(final Player p) {
        if (isPlayerInEvent(p))
            return Events.playerEvent.get(p.getName());
        return null;
    }

    public String currentEvent() {
        return this.currentEvent;
    }

    public String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public String randomArena(final List<?> Arenas) {
        return (String) Arenas.get(new Random().nextInt(Arenas.size()));
    }

    public void addPlayerPoints(Player p, int Points) {
        int playerPoints = 0;
        if (Events.getConfig().get(p.getName()) != null) {
            playerPoints = Events.getConfig().getInt(p.getName()) + Points;
            Events.getConfig().set(p.getName(), playerPoints);
        } else {
            Events.getConfig().set(p.getName(), playerPoints + Points);
        }
    }

    public void removePlayerPoints(Player p, int Points) {
        int playerPoints = 0;
        if (Events.getConfig().get(p.getName()) != null) {
            playerPoints = Events.getConfig().getInt(p.getName()) - Points;
            Events.getConfig().set(p.getName(), playerPoints);
        } else {
            Events.getConfig().set(p.getName(), playerPoints - Points);
        }
    }

}
