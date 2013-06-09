package me.ultimate.E;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.earth2me.essentials.Essentials;

public class EventsListener implements Listener {

    Events Events;

    public EventsListener(final Events e) {
        Events = e;
    }

    EventsMethods util = new EventsMethods();
    Essentials ess = new Essentials();

    @EventHandler
    public void onListPlayer(final ServerListPingEvent event) {
        event.setMotd(util.t("&6[&aCE&6] &eWelcome to Coalition Events!"));
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        if (!util.isPlayerInEvent(event.getPlayer())
                && event.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase("Spawn")) {
            final ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            final ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            final ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            final ItemStack helm = new ItemStack(Material.LEATHER_HELMET, 1);
            final LeatherArmorMeta bmeta = (LeatherArmorMeta) boots.getItemMeta();
            final LeatherArmorMeta cmeta = (LeatherArmorMeta) chest.getItemMeta();
            final LeatherArmorMeta lmeta = (LeatherArmorMeta) leg.getItemMeta();
            final LeatherArmorMeta hmeta = (LeatherArmorMeta) helm.getItemMeta();
            if (event.getPlayer().hasPermission("events.admin")) {
                bmeta.setColor(Color.RED);
                cmeta.setColor(Color.RED);
                lmeta.setColor(Color.RED);
                hmeta.setColor(Color.RED);
            } else if (event.getPlayer().hasPermission("events.donor")) {
                bmeta.setColor(Color.ORANGE);
                cmeta.setColor(Color.ORANGE);
                lmeta.setColor(Color.ORANGE);
                hmeta.setColor(Color.ORANGE);
            } else {
                bmeta.setColor(Color.WHITE);
                cmeta.setColor(Color.WHITE);
                lmeta.setColor(Color.WHITE);
                hmeta.setColor(Color.WHITE);
            }
            boots.setItemMeta(bmeta);
            chest.setItemMeta(cmeta);
            leg.setItemMeta(lmeta);
            helm.setItemMeta(hmeta);
            event.getPlayer().getInventory().setBoots(boots);
            event.getPlayer().getInventory().setChestplate(chest);
            event.getPlayer().getInventory().setLeggings(leg);
            event.getPlayer().getInventory().setHelmet(helm);
        }
        event.setJoinMessage(util.t("&e[&a*&e]&3 " + event.getPlayer().getName() + "&f has connected."));
    }
}
