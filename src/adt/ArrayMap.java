/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author lzhao
 * @param <T>
 * @param <Q>
 */
public class ArrayMap <T,Q> implements MapInterface<T,Q>{
   private T key[];
   private Q value[];
   private  int size;
   final static int MAX_SIZE=10; 
    
    public ArrayMap (){
        
        this(MAX_SIZE);
    }
        public ArrayMap (int size){
        
        key= (T[])new Object[size];
        value= (Q[])new Object[size];
        this.size=0;
    }
    
    @Override
    public boolean put(T key, Q value) {
        if (contains(key))
        return false;
        if (isFull())
            expandArray();
         this.key[size]=key;
         this.value[size]=value;
         size++;
        return true;
    }
     @Override
    public boolean put(T key) {
        
        if (isEmpty())
            this.key[0]=key;
        else
        {
            if(isFull())
            expandArray();
         this.key[size]=key;
        }
        size++;
       return true;
    }

    @Override
    public Q getValue(T key) {
        for ( int i =0; i < size; i ++)
            if (this.key[i].equals(key))
                return value[i];
          return null;
    }
    



    @Override
    public boolean replace(T key, Q newValue) {
        for (int i=0; i < size; i++)
            if (this.key[i].equals(key)){
            value[i] = newValue;
            return true;
            }
               
        return false;
  
    }

    @Override
    public boolean remove(T key) {
      for ( int i =0; i < size; i ++){
            if (this.key[i].equals(key)){
                this.key[i]=null;
                this.value[i]=null;
                if (size !=1)
                removeGap(i);
                --size;
                return true;
            }
      }
     
     return false;
     
    }

    @Override
    public boolean isEmpty() {
       return size == 0;
    }

    @Override
    public boolean isFull() {
       return size == key.length;
    }

    @Override
    public int getSize() {
     return size;
    }

    @Override
    public void clear() {
     size =0;
     
    }

   @Override
   public boolean contains(T key){
       for (int i=0; i< size; i++){
           if ((this.key[i]).equals(key))
               return true;
       }
          return false;
   }
   
   private void removeGap(int index){

       for (int i=index; i< size-1; i++){
           key[i]=key[i+1];
           value[i]=value[i+1];
       }
     
   }
   private void expandArray(){
    T temparray[]= (T[])new Object[key.length+MAX_SIZE];
    Q temparray2[]= (Q[])new Object[key.length+MAX_SIZE];
    for (int i =0; i < key.length;i++){
    temparray[i]=key[i];
    temparray2[i]=value[i];
    }
    
    key=temparray;
    value=temparray2;
   }
   

 
  
   
}
