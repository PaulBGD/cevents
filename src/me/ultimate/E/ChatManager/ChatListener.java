package me.ultimate.E.ChatManager;

//import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
//import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.earth2me.essentials.Essentials;

import me.ultimate.E.Events;

public class ChatListener implements Listener {

    Events Events;

    public ChatListener(Events main) {
        Events = main;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Essentials ess = Events.getEssentials();
        Player p = event.getPlayer();
        String name = event.getPlayer().getName();
        if (ess.getUser(p)._getNickname() != null)
            name = ess.getUser(p)._getNickname();
        if (!p.hasPermission("events.chat.admin")) {
            String format = t("&e" + name + " &l>> &r");
            event.setFormat(format + event.getMessage());
        } else
            event.setFormat(t("&c" + name + " &4&l>> &r&c" + event.getMessage()));

    }

    //List<?> aCommands = Events.getConfig().getList("AllowedCommands");

    /*@EventHandler
    public void onCmdProccess(PlayerCommandPreprocessEvent event) {
        for (Object aC : aCommands)
            if (event.getMessage().startsWith("/") && !event.getPlayer().hasPermission("events.admin")
                    && !event.getMessage().startsWith(aC.toString())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(t("&cYou don't need to do that!"));
            }

    }*/

    public String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
