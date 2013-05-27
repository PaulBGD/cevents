package me.ultimate.E.ChatManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

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
        if (!p.hasPermission("events.chat.admin")) {
            String format = t("&e" + ess.getUser(p)._getNickname() + " &l>> &r");
            event.setFormat(format + event.getMessage());
        } else {
            event.setFormat(t("&c" + ess.getUser(p)._getNickname() + " &4&l>> &r&c" + event.getMessage()));
        }

    }

    @EventHandler
    public void onCmdProccess(PlayerCommandPreprocessEvent event) {
        if(event.getMessage().startsWith("/") && !event.getPlayer().hasPermission("events.admin") && !event.getMessage().startsWith("events")){
            event.setCancelled(true);
            event.getPlayer().sendMessage(t("&cYou don't need to do that!"));
        }
            
    }

    public String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
