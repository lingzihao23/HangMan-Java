/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import entity.*;
import adt.*;
import java.util.Arrays;
/**
 *
 * @author lzhao
 */

public class Testrun {
 
       private  RandomInterface <Question> questionList =new RandomLinkedList<Question>();
       private MapInterface <Character,int[]> map ;

        public Testrun() {
        Question question[] = new Question[4];
        question[0]= new Question("Zebra", "Easy","Easy");
        question[1]= new Question("Poop", "Easy","Easy");
        question[2]= new Question("Ostrich", "Easy","Easy");
        question[3]= new Question("Apple", "Easy","Easy");
        
        questionList.add(question);
        map=question[1].getLetterFrequency();
        

        System.out.print(map.getSize());
        map.remove('Z');
        System.out.print(map.getValue('o')[0]);
        System.out.print(map.getSize());
      
      
      
//        System.out.print(map.contains('e'));
    


        
  
    }
       
       
       
    public static void main(String[] args) {
        
       new Testrun();
        
    }
}