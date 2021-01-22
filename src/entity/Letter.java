/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.swing.JButton;

/**
 *
 * @author OWNER
 */
public class Letter {
    public char alphabet;
    private boolean isClicked;
    public JButton keyBoard[];
    

    public Letter() {
    }
    
    public Letter(char alphabet) {
        this.alphabet = alphabet;
    }

    public Letter(JButton[] keyBoard) {
        this.keyBoard = keyBoard;
    }
    
    
    
    public char getAlphabet() {
        return alphabet;
    }

    public boolean isClicked() {
        return isClicked;
    }

    @Override
    public String toString() {
        return "Letter{" + "alphabet=" + alphabet + ", isClicked=" + isClicked + '}';
    }



    
    
}