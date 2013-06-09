/*
* ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
* ANY use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!
* ***********************************************************************************************************
*/
package me.ultimate.E;

import java.util.HashMap;

//imports here, editing by hand so I have no idea what they are

public class Score {

    private final Score impl;
    private final HashMap<String, Double> scoreBoard = new HashMap<String, Double>();

    /**
     * 
     * Used to start a new score
     * 
     */
    public Score() {
        impl = this;
    }

    public void addScore(final String playerName, final double score) {
        if (scoreBoard.get(playerName) != null) {
            scoreBoard.put(playerName, getScore(playerName) + score);
        } else {
            scoreBoard.put(playerName, score);
        }
    }

    public Score getImpl() {
        return impl;
    }

    /**
     * 
     * Get the players score that is stored
     * used mostly  
     */
    public double getScore(final String playerName) {
        return scoreBoard.get(playerName);
    }
}