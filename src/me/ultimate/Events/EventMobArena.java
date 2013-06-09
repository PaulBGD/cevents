/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          ANY use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.Events;

import java.util.List;

import me.ultimate.E.Events;
import me.ultimate.E.EventsMethods;

import org.bukkit.entity.Player;

public class EventMobArena implements BasicEvent {

    private final Events Events = new Events();

    //Methods
    List<?> Arenas = Events.getConfig().getList("MobArena.Arenas");

    @Override
    public void onStart(List<Player> players) {
        for (Player p : players) {
            if (p.isOnline()) {
                p.chat("/ma join " + new EventsMethods().randomArena(Arenas));
            }
        }
    }

    @Override
    public void onEnd() {
        //Some code to check the the arena is still running. Wait... I gotta setup the players in event method
    }

    @Override
    public void onPublicStart() {
        
    }

}
