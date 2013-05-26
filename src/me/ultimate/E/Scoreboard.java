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
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scoreboard extends BukkitRunnable {

    private final JavaPlugin plugin;

    public Scoreboard(final JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getLogger().info("Started scoreboard!");
    }

    long time;
    Events Events = new Events();

    //This runs every second, updating the board. Seconds will show if minutes are under 1.
    @Override
    public void run() {
        org.bukkit.scoreboard.Scoreboard board;
        final ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
        final Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(t("&6&l-=-[ " + Events.getUtil().currentEvent + " ]-=-"));
        final long ms = Calendar.getInstance().getTimeInMillis();
        if (time <= ms) {
            Events.getUtil().startEvent();
            time = ms + 900000;
            Events.getUtil().preEvent();
            plugin.getLogger().info(Events.getUtil().currentEvent());
        }
        final int m2s = (int) (TimeUnit.MILLISECONDS.toMinutes(time - ms) * 60);
        final int finalS = (int) TimeUnit.MILLISECONDS.toSeconds(time - ms) - m2s;
        final Score score = objective.getScore(Bukkit.getOfflinePlayer(t("Minutes: ")));
        score.setScore((int) TimeUnit.MILLISECONDS.toMinutes(time - ms));
        for (final Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(board);
            if (TimeUnit.MILLISECONDS.toMinutes(time - ms) > 0) {
                p.setLevel((int) TimeUnit.MILLISECONDS.toMinutes(time - ms));
            } else {
                p.setLevel(finalS);
            }
            p.setExp((float) ((finalS * 1.6) / 100.0f));
        }
    }

    String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
