/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lzhao
 */
public class Hint {
   private  char hintLetter[];
   private  int  hintUsed;
   private  int  pointsDeductEach;
   private  int  maxUse;
   private  final static int DEFAULT_MAX =3;

   public Hint (){
   this.hintLetter= new char [DEFAULT_MAX];
   this.hintUsed++;
   this.maxUse=DEFAULT_MAX;
   }
   
    public Hint (int maxused, int pointsDeductEach) {
        this.hintLetter = new char [maxused];
        this.maxUse=maxused;
        this.hintUsed = 0;
        this.pointsDeductEach=pointsDeductEach;
    }

    public char[] getHintLetter() {
        return hintLetter;
    }

    public int getHintUsed() {
        return hintUsed;
    }

    public int getPointsDeductEach() {
        return pointsDeductEach;
    } 

    public int getMaxUse() {
        return maxUse;
    }
   
    public boolean addHintLetter(char entry){
        if (hintUsed==maxUse)
            return false;
        
        this.hintLetter[hintUsed]=entry;
        hintUsed++;
        return true;
        
    }

    public void setHintLetter(char[] hintLetter) {
        this.hintLetter = hintLetter;
    }

    public void setHintUsed(int hintUsed) {
        this.hintUsed = hintUsed;
    }

    public void setPointsDeductEach(int pointsDeductEach) {
        this.pointsDeductEach = pointsDeductEach;
    }
    
    public boolean contains (char entry){
    for (int i =0; i < hintLetter.length;i++)
        if (hintLetter[i]==(entry) )
            return true;
        
    return false;
    }
   
    
   
   
   
   
   
   
   
   
   
   
   
}