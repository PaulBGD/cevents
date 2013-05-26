/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          ANY use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.Events;

import java.util.List;

import me.ultimate.E.EventsMethods;
import me.ultimate.E.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import com.garbagemule.MobArena.MobArenaHandler;

public class EventMobArena implements Listener {

    MobArenaHandler ma = setupMobArenaHandler();

    public MobArenaHandler setupMobArenaHandler() {
        final Plugin maPlugin = Bukkit.getServer().getPluginManager().getPlugin("MobArena");
        if (maPlugin == null)
            return null;
        return new MobArenaHandler();
    }

    private final Events Events = new Events();

    //Methods
    List<?> Arenas = Events.getConfig().getList("MobArena.Arenas");

    public void onStart(final List<Player> players) {
        for (final Player p : players) {
            if (p.isOnline())
                p.chat("/ma join " + new EventsMethods(Events).randomArena(Arenas));
        }
    }

    public void onEnd() {
        //Some code to check the the arena is still running. Wait... I gotta setup the players in event method
    }

    //Events
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        Player p = event.getEntity();
        if (ma.getArenaAtLocation(p.getLocation()) != null)
            new EventsMethods(Events).removePlayerFromEvent(p.getName());
    }

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {
        if (event.getEntity() instanceof LivingEntity && event.getEntity().getKiller() instanceof Player) {
            if(ma.getArenaWithMonster(event.getEntity()) != null){
                new EventsMethods(Events).addPlayerPoints(event.getEntity().getKiller(), 1);
            if(ma.getArenaWithMonster(event.getEntity()).getMonsterManager().getBossMonsters().contains(event.getEntity()))
                new EventsMethods(Events).addPlayerPoints(event.getEntity().getKiller(), 2);
            }
            
        }
    }
}
