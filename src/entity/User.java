/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.ArrListGameResults;
import adt.ArrListGameResultsInterface;
import java.util.Objects;

/**
 *
 * @author Kelly Lai
 */
public class User{

    private String name;
    private int highestRank;
    private int highestScore;
    private ArrListGameResultsInterface <GameResult> gameResult;

    public User(String name, ArrListGameResults <GameResult> gameResult) {
        this.name = name;
        this.gameResult = gameResult;
    }

    public User() {

    }

    public User(String name) {
        this.name = name;
        this.gameResult= new ArrListGameResults<GameResult>();
    }
    
    public User(String name, int highestRank, int highestScore) {
        this.name = name;
        this.highestRank = highestRank;
        this.highestScore = highestScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHighestRank(int highestRank) {
        this.highestRank = highestRank;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public String getName() {
        return this.name;
    }

    public int getHighestRank() {
        return highestRank;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setGameResult(ArrListGameResultsInterface<GameResult> gameResult) {
        this.gameResult = gameResult;
    }
    
    
    public ArrListGameResultsInterface <GameResult> getGameResult(){
        return this.gameResult;
 }

    @Override
    public String toString() {
        return "name=" + name + ", highestRank=" + highestRank + ", highestScore=" + highestScore;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
   
    
    

}
