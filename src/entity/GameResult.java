/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.Objects;

/**
 *
 * @author OWNER
 */
public class GameResult {
    private String difficulty;
    private boolean win;
    private int roundCompleted;
    private int totalscore;
    public static int newResult=1;

    public GameResult() {
    }
    
    
   
    public GameResult(String difficulty, boolean win, int roundCompleted, int totalscore) {
        this.difficulty = difficulty;
        this.win = win;
        this.roundCompleted = roundCompleted;
        this.totalscore = totalscore;
        newResult++;
    }

    public GameResult(boolean win) {
        this.win = win;
    }
    
    public GameResult(int roundCompleted) {
        this.roundCompleted = roundCompleted;
    }
  

    public String getGameDifficulty() {
        return difficulty;
    }

   public boolean isWin(){
      return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    
   

    public int getRoundCompleted() {
        return roundCompleted;
    }

    public int getTotalscore() {
        return  totalscore;
    }
    

    @Override
    public String toString() {
        String message;
        if (win ==true)
            message="Win";
            else 
         message = "Lose";
        return "Difficulty: "+difficulty + " Status: "+ message+ " Rounds Completed: "+ roundCompleted + " Total Score: "+ totalscore;
    }
     
     
      
}
