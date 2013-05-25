/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          Any use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.E;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.ultimate.Events.EventMobArena;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EventsMethods {

    EventsData data = new EventsData();

    Events Events = new Events();
    EventMobArena MobArena = new EventMobArena(Events);

    public void startEvent() {
        int eventNum = new Random().nextInt(1);
        List<Player> players = new ArrayList<Player>();
        for (Player p : Bukkit.getOnlinePlayers())
            if (!this.isPlayerInEvent(p))
                players.add(p);
        switch (eventNum) {
        case 1:
            MobArena.onStart(players);
            break;
        default:
            Events.getLogger().severe("Cannot start event! Restart server right away!");
        }
    }

    public List<String> playersInEvent(String event) {
        List<String> playersInEvent = new ArrayList<String>();
        for (Player player : Bukkit.getOnlinePlayers())
            if (data.playerEvent.containsKey(player.getName()))
                playersInEvent.add(player.getName());
        return playersInEvent;
    }

    public boolean removePlayerFromEvent(String name) {
        if (data.playerEvent.containsKey(name)) {
            data.playerEvent.remove(name);
            return true;
        }
        return false;
    }

    public Boolean isPlayerInEvent(Player p) {
        if (data.playerEvent.containsKey(p.getName()))
            return true;
        return false;
    }

    public String getEventByPlayer(Player p) {
        if (isPlayerInEvent(p))
            return data.playerEvent.get(p.getName());
        return null;
    }

    public String currentEvent() {
        return data.currentEvent;
    }
}
