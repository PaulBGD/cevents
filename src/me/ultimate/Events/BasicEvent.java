package me.ultimate.Events;

import java.util.List;

import org.bukkit.entity.Player;

public interface BasicEvent {

    void onPublicStart();
    void onStart(List<Player> p);

    void onEnd();
}
