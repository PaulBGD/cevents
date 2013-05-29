/*
 * ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
 *          Any use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!  
 * ***********************************************************************************************************           
 */
package me.ultimate.E;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class EventsData {

    //HashMap take <Player name. whatever this is for> 
    //Try to never store the player if you can help it use the getPlayer method from the server
    HashMap<String, String>playerEvent = new HashMap<String, String>();
    String currentEvent;
    
}
