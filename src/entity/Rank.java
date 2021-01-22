/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.lang.*;
import java.util.Objects;
import java.util.Arrays;
import adt.*;
/**
 *
 * @author zichew
 */
public class Rank implements Comparable<Rank> {
    
    private String difficulty;
    private String name;
    private int score;
    private int stage;
    static int ranking=0;
    

    public Rank() {
        difficulty="";
        name="";
        stage=0;
        score=0;
    }

    public Rank(String difficulty, String name) {
        this.difficulty = difficulty;
        this.name = name;
    }
    
    public Rank(int score) {
        this.score = score;
    }

    public Rank(String name) {
        this.name = name;
    }

    public Rank(String difficulty, String name, int score, int stage) {
        this.difficulty = difficulty;
        this.name = name;
        this.score = score;
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
    public int getRanking(){
        Rank.ranking+=1;
        return Rank.ranking;
    }
    public int resetRanking(){
        Rank.ranking=0;
        return Rank.ranking;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    
    public void giveScoreTo(Rank aScore) {
    aScore.setScore(score);
  } 

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.getRanking()+ "  " + difficulty + "  " + name + "  " + score + "  " + stage;
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
        final Rank other = (Rank) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.difficulty, other.difficulty)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.difficulty);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.score;
        hash = 79 * hash + this.stage;
        return hash;
    }

    @Override
    public int compareTo(Rank newScore) {
       int result;
        result= Integer.compare(score, newScore.score);
    return result;
    }

   
   




  




   
    
  
}
