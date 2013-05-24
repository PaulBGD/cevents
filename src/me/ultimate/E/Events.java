package me.ultimate.E;

/*import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;*/
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Events extends JavaPlugin {

    Location loc;
    String eventName;

    /* Just some code I figured out for the scoreboard. Already tested. Score can only be 16 characters 
    (including color codes). Display name, 30.
    Player p = ((Player) sender);
    Scoreboard board;
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    board = manager.getNewScoreboard();   
    Objective objective = board.registerNewObjective("test", "dummy");
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    objective.setDisplayName(cct("&6&l-=-[ Coalition Events ]-=-"));
    Score score = objective.getScore(Bukkit.getOfflinePlayer(cct("Stuff on left here.")));
    score.setScore(3);
    p.setScoreboard(board);*/
    String t(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
