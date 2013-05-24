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

    public Scoreboard(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    long time;

    public void run() {
        org.bukkit.scoreboard.Scoreboard board;
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = (org.bukkit.scoreboard.Scoreboard) manager.getNewScoreboard();
        Objective objective = ((org.bukkit.scoreboard.Scoreboard) board).registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(t("&6&l-=-[ Coalition Events ]-=-"));
        long ms = Calendar.getInstance().getTimeInMillis();
        if (time == 0)
            time = ms + 900000;
        if (time == ms)
            time = 0;
        int m2s = (int) (TimeUnit.MILLISECONDS.toMinutes(time - ms) * 60);
        int finalS = (int) TimeUnit.MILLISECONDS.toSeconds(time - ms) - m2s;
        plugin.getLogger().info(m2s + "    " + finalS);
        Score score = objective.getScore(Bukkit.getOfflinePlayer(t("Minutes: ")));
        score.setScore((int) TimeUnit.MILLISECONDS.toMinutes(time - ms));
        Score score2 = objective.getScore(Bukkit.getOfflinePlayer(t("Seconds:")));
        score2.setScore(finalS);
        for (Player p : Bukkit.getOnlinePlayers())
            p.setScoreboard(board);
    }

    String t(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
