package me.ultimate.E.ChatManager;

import me.ultimate.E.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.earth2me.essentials.Essentials;

public class ChatListener implements Listener {

    Events Events;

    public ChatListener(final Events main) {
        Events = main;
    }

    @EventHandler
    public void onAsyncPlayerChat(final AsyncPlayerChatEvent event) {
        final Essentials ess = Events.getEssentials();
        final Player p = event.getPlayer();
        String name = event.getPlayer().getName();
        if (ess.getUser(p)._getNickname() != null)
            name = ess.getUser(p)._getNickname();
        if (!p.hasPermission("events.chat.admin")) {
            final String format = t("&e" + name + " &l>> &r");
            event.setFormat(format + event.getMessage());
        } else
            event.setFormat(t("&c" + name + " &4&l>> &r&c" + event.getMessage()));

    }

    @EventHandler
    public void onCmdProccess(final PlayerCommandPreprocessEvent event) {
        if (event.getMessage().startsWith("/") && !event.getPlayer().hasPermission("events.admin")
                && !event.getMessage().startsWith("/skip") && !event.getMessage().startsWith("/join")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(t("&cYou don't need to do that!"));
        }
        /*String arr[] = event.getMessage().split(" ", 2);
        String firstWord = arr[0];
        Events.getLogger().info("1");
        Events.getLogger().info(Events.getServer().getPluginCommand(firstWord) + "");
        if(Events.getServer().getPluginCommand(firstWord) == null){
            Events.getLogger().info("2");
            event.getPlayer().sendMessage(t("&cIt... does not... EXIST!"));
            event.setCancelled(true);
        }*/

    }

    public String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
