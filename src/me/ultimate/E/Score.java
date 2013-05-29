/*
* ************************************* Coded by Ultimate + ShadowLordAlpha *********************************
* ANY use of this not on the server Coalition Events/Mini-Games is strictly PROHIBITED!
* ***********************************************************************************************************
*/
package me.ultimate.E;

//imports here, editing by hand so I have no idea what they are

public class Score {

  private Score impl;
  private HashMap<String, String> scoreBoard = new HashMap<String, String>();

  /**
   *
   *Used to start a new score
   *
   */
  public Score() {
    implementaion = this;
  }
  
  public void addScore(String playerName, double score) {
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
   *Get the players score that is stored
   *used mostly internaly
   */
  public double getScore(String playerName) {
  
    return scoreBoard.get(playerName);
  }
  
  /**
   * Returns a full HashMap of all the scores and players in the HashMap
   * 
   */
  public HashMap<String, String> getScoreBoard() {
    return scoreBoard;
  }

}
