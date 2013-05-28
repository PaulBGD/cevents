/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          Any use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.E;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    private final JavaPlugin plugin;

    public Timer(final JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getLogger().info("Started scoreboard!");
    }

    long time;
    Events Events = new Events();

    //This runs every second, updating the timer.
    @Override
    public void run() {
        final long ms = Calendar.getInstance().getTimeInMillis();
        if (time <= ms) {
            Events.getUtil().startEvent();
            time = ms + 900000;
            Events.getUtil().preEvent();
            plugin.getLogger().info(Events.getUtil().currentEvent());
        }
        final int m2s = (int) (TimeUnit.MILLISECONDS.toMinutes(time - ms) * 60);
        final int finalS = (int) TimeUnit.MILLISECONDS.toSeconds(time - ms) - m2s;
        for (final Player p : Bukkit.getOnlinePlayers()) {
            if (TimeUnit.MILLISECONDS.toMinutes(time - ms) > 0) {
                p.setLevel((int) TimeUnit.MILLISECONDS.toMinutes(time - ms));
            } else {
                p.setLevel(finalS);
            }
            float exp = (float) (time - ms) / 60000;
            p.setExp((float) exp - ((int) TimeUnit.MILLISECONDS.toMinutes(time - ms)));
            p.setExhaustion(0);
            p.setFoodLevel(20);
        }
    }

    String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
