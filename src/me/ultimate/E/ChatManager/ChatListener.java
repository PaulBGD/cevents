package me.ultimate.E.ChatManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.ultimate.E.Events;

public class ChatListener implements Listener {

    Events Events;

    public ChatListener(Events main) {
        Events = main;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if (!p.hasPermission("events.chat")) {
            event.setFormat(t("&e" + p.getCustomName() + " &l>> &r" + event.getMessage()));
        } else {
            event.setFormat(t("&c" + p.getCustomName() + " &4&l>> &r&c" + event.getMessage()));
        }
        String message = event.getMessage();
        message.replaceAll(" u ", "you");
        message.replaceAll(" im ", " I'm ");
        message.replaceAll(" y ", " why ");
    }

    public String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
