package me.ultimate.E;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EventPlayer {

    EventPlayer ePlayer;
    String ePN;
    EventsMethods Utils = new EventsMethods();
    Events Events = new Events();

    public EventPlayer(Player p) {
        ePlayer = (EventPlayer) p;
        ePN = p.getName();
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(ePN);
    }

    public String getName() {
        return ePN;
    }

    public String getEvent(EventPlayer eP) {
        if (Utils.isPlayerInEvent(getPlayer()))
            return Events.playerEvent.get(getName());
        return null;
    }

    public boolean inEvent() {
        return Utils.isPlayerInEvent(getPlayer());
    }

    public boolean removePlayerFromEvent() {
        if (Events.playerEvent.containsKey(ePN)) {
            Events.playerEvent.remove(ePN);
            return true;
        }
        return false;
    }
}
