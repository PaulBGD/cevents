/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          Any use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.Events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.garbagemule.MobArena.MobArenaHandler;

public class EventMobArena {

    MobArenaHandler ma = setupMobArenaHandler();

    public MobArenaHandler setupMobArenaHandler() {
        final Plugin maPlugin = Bukkit.getServer().getPluginManager().getPlugin("MobArena");
        if (maPlugin == null)
            return null;
        return new MobArenaHandler();
    }

    public EventMobArena(final me.ultimate.E.Events plugin) {
        this.Events = plugin;
    }

    @SuppressWarnings("unused")
    private final me.ultimate.E.Events Events;

    //Methods
    
    public void onStart(List<Player> players) {
        for (Player p : players) {
            if (p.isOnline())
                p.chat("/ma join");
        }
    }
    public void onEnd(){
        //Some code to check the the arena is still running. Wait... I gotta setup the players in event method
    }
}
