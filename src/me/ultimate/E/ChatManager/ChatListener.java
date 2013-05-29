package me.ultimate.E.ChatManager;

import java.util.List;

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

    List<?>aCommands = Events.getConfig().getList("AllowedCommands");
    @EventHandler
    public void onCmdProccess(PlayerCommandPreprocessEvent event) {
        for(Object aC : aCommands)
        if (event.getMessage().startsWith("/") && !event.getPlayer().hasPermission("events.admin")
                && !event.getMessage().startsWith(aC.toString())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(t("&cYou don't need to do that!"));
        }

    }

    private String t(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    
    //fun little thing I thought up 
    //also I am eding by hand (no editor) so you may need to check things -shadowlordalha
    //This is a fully configuralble %*word*% replacer
    private String otherThing(String msg) {
        String newMsg = "";
        String symbol = /*get a string from the config to use as the symbol*/;
        if (msg.contains(symbol) {
            String[] splitMsg = msg.split(" ");
            for (String s: splitMsg) {
                if (s.startsWith(symbol) && s.endsWith(symbol)) {
                    s = s.replace(symbol, "");
                    for (Stting s2: /* get all the config keys for different words*/) {
                        if (s.equalsIgnoreCase(s2)) {
                            s = /*getString the config with s2 as the key*/;
                            break; //leave the loop
                        }
                    }
                }
                
                newMsg += s + " ";
            }
            newMsg = newMsg.trim();
            return newMsg;
        }
        return msg;
    }
}
