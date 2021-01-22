/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;
import entity.GameResult;
/**
 *
 * @author OWNER
 */
public class ArrListGameResults <G> implements ArrListGameResultsInterface <G>{
      private int length;
      private G[] resultList;
      private  static final int DEFAULT_SIZE=10;

     public ArrListGameResults() {
        this(DEFAULT_SIZE);
      }
    
     public ArrListGameResults(int first) {
      if (first <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }

        this.resultList =(G[]) new Object [first];
        this.length = 0;
      }
    
    public boolean add(G newEntry) {
        if(isFull()){
          copyArray(0, "double");
       }
        
        resultList[length] = newEntry;
        length++;
        return true;
       
     }
    
      public boolean replace(int givenPos, G newEntry) {
      boolean isReplace = true;

      if ((givenPos >= 1) && (givenPos <= length)) {
       resultList[givenPos - 1] = newEntry;
       } else {
       isReplace = false;
       }

       return isReplace;
      }
      
      public G getEntry(int givenPos){
          G result=null;
          
          if ((givenPos >= 1) && (givenPos <= length)) {
          result = resultList[givenPos - 1];
          }

       return result; 
      }
      
      public G get(int index){
          return resultList[index];
      }
      
      public int getLength() {
       return length;
      }

        
    public boolean isFull(){
        if (length >= DEFAULT_SIZE) {
            return true;
        } else {
            return false;
        }
    }      
    
    public boolean isEmpty(){
        if(length==0){
            return true;
        }
        else{
            return false;
        }
    }
    
   public void copyArray(int size,String action){
          size = increaseArraySize(size, action);

        G [] tempArray =(G[]) new Object [size];
            
        int tempElement = 0;

        for (int i = 0; i < this.resultList.length; i++, tempElement++) {
            if (this.resultList[i] == null) {
                tempElement--;
                continue;
            }

            tempArray[tempElement] = this.resultList[i];
        }

        this.resultList = null;
        this.resultList =(G[]) new Object [tempArray.length];
        this.resultList = tempArray;
   }
   
   public int increaseArraySize(int size, String action) {
        if (action.equals("double")) {
            size = this.resultList.length * 2;
        } else {
            size = this.resultList.length + size;
        }

        return size;
    }
 
}
