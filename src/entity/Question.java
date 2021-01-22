/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.ArrayMap;
import adt.MapInterface;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author lzhao
 */
public class Question {

    private String word;
    private String description;
    private String difficulty;
    private int points;
    private MapInterface<Character, int[]> letterFrequency = new ArrayMap<Character, int[]>();

    public Question(String word, String description, String difficulty) {
        this.word = word;
        this.description = description;
        this.difficulty=difficulty;
        if ((this.difficulty).equals("Easy")) {
            points = 10;
        } else if ((this.difficulty).equals("Medium")) {
            points = 15;
        } else {
            points = 20;
        }
        findDistinctCharacter();
    }

    public String getWord() {
        return word;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }

    public char generateHint() {
        int index = (int) (Math.random() * word.length());
        return word.charAt(index);

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MapInterface<Character, int[]> getLetterFrequency() {
        return letterFrequency;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Question other = (Question) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }

    private void findDistinctCharacter() {
       letterFrequency.put(word.charAt(0),positionOfChar(word.charAt(0)));
        for (int i = 1; i < word.length(); i++) {
            if (!letterFrequency.contains(word.charAt(i))) {
                int letterPosition []=positionOfChar(word.charAt(i));
                letterFrequency.put(word.charAt(i),letterPosition);
             }
        }
//    
 
      
         

    }

    private int[] positionOfChar(char letter) {
        int k = 0;
        int positionArray[]=new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                positionArray[k]=i;
                k++;
            }
        }
        int temp []= new int[k];
        for (int i=0; i <k;i++)
         temp[i]=positionArray[i];
        
        return temp;
    }
   
}
