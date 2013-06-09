/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          ANY use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.Events;

import me.ultimate.E.EventsMethods;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import com.garbagemule.MobArena.MobArenaHandler;

public class EventMobArenaListener implements Listener{

    MobArenaHandler ma = setupMobArenaHandler();

    public MobArenaHandler setupMobArenaHandler() {
        final Plugin maPlugin = Bukkit.getServer().getPluginManager().getPlugin("MobArena");
        if (maPlugin == null)
            return null;
        return new MobArenaHandler();
    }
    
    @EventHandler
    public void onPlayerDeathEvent(final PlayerDeathEvent event) {
        final Player p = event.getEntity();
        if (ma.getArenaAtLocation(p.getLocation()) != null)
            new EventsMethods().removePlayerFromEvent(p.getName());
    }

    @EventHandler
    public void onEntityDeathEvent(final EntityDeathEvent event) {
        if (event.getEntity() instanceof LivingEntity && event.getEntity().getKiller() instanceof Player) {
            if (ma.getArenaWithMonster(event.getEntity()) != null) {
                new EventsMethods().addPlayerPoints(event.getEntity().getKiller(), 1);
                if (ma.getArenaWithMonster(event.getEntity()).getMonsterManager().getBossMonsters()
                        .contains(event.getEntity()))
                    new EventsMethods().addPlayerPoints(event.getEntity().getKiller(), 2);
            }

        }
    }
    
}
