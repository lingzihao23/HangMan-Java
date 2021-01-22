/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Stage {  
    
    private String difficulty;
    private int level ;
    private int wAttempts ;
    private int currentState;
    private int stageScore;
    private boolean isCompleted;
    private Question currentQuestion;
    
    public Stage(){

    }

    public Stage(String difficulty, int level, Question currentQuestion) {
        this.difficulty = difficulty;
        this.level = level;
        wAttempts =0;
        currentState=0;
        stageScore=0;
        isCompleted=false;
        this.currentQuestion = currentQuestion;
    }
    

    public Stage(String difficulty, int level, int wAttempts, int currentState, int stageScore, boolean isCompleted, Question currentQuestion) {
        this.difficulty = difficulty;
        this.level = level;
        this.wAttempts = wAttempts;
        this.currentState = currentState;
        this.stageScore = stageScore;
        this.isCompleted = isCompleted;
        this.currentQuestion = currentQuestion;
    }
    
    public Stage(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getLevel() {
        return level;
    }

    public int getwAttempts() {
        return wAttempts;
    }
    
    public int getCurrentState() {
        return currentState;
    }
    
    public int getStageScore() {
        return stageScore;
    }
    
    public boolean getIsCompleted() {
        return isCompleted;
    }
    
     public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setwAttempts(int wAttempts) {
        this.wAttempts = wAttempts;
    }
    
    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }
    
    public void setStageScore(int stageScore) {
        this.stageScore = stageScore;
    }
    
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
     public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
    
    @Override
    public String toString() {
        return "Stage{" + "difficulty=" + difficulty + ", level=" + level + ", wAttempts=" + wAttempts + "stage score=" + stageScore + '}';
    }
  
}








