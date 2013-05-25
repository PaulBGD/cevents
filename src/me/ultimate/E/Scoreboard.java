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

    @SuppressWarnings("unused")
    private final JavaPlugin plugin;

    public Scoreboard(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    long time;

    //This runs every second, updating the board. Seconds will show if minutes are under 1.
    public void run() {
        org.bukkit.scoreboard.Scoreboard board;
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = (org.bukkit.scoreboard.Scoreboard) manager.getNewScoreboard();
        Objective objective = ((org.bukkit.scoreboard.Scoreboard) board).registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(t("&6&l-=-[ " + "Insert Game Here" + " ]-=-"));
        long ms = Calendar.getInstance().getTimeInMillis();
        if (time <= ms)
            time = ms + 900000;
        int m2s = (int) (TimeUnit.MILLISECONDS.toMinutes(time - ms) * 60);
        int finalS = (int) TimeUnit.MILLISECONDS.toSeconds(time - ms) - m2s;
        if (TimeUnit.MILLISECONDS.toMinutes(time - ms) > 0) {
            Score score = objective.getScore(Bukkit.getOfflinePlayer(t("Minutes: ")));
            score.setScore((int) TimeUnit.MILLISECONDS.toMinutes(time - ms));
        } else {
            Score score2 = objective.getScore(Bukkit.getOfflinePlayer(t("Seconds:")));
            score2.setScore(finalS);
        }
        for (Player p : Bukkit.getOnlinePlayers())
            p.setScoreboard(board);
    }

    String t(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
