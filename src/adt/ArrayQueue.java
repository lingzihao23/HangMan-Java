package adt;

public class ArrayQueue<Q> implements ArrayQueueInterface<Q>{
    
    private int currentLevel; //firstIndex
    private int lastIndex;
    private int size;
    private int length;
    private Q[] stageQueues;
    
    public ArrayQueue()
    {
        currentLevel=0;
        lastIndex=0;
        length=0;
        size=10;
        stageQueues = (Q[]) new Object [size];
    }      
    
    public boolean enqueue(Q newEntry)
    {
        
        if(isFull())
        {
            return false;
        }
        
        else
        {
            stageQueues[lastIndex] = newEntry;
            lastIndex++;
            currentLevel++;
            length++;
            return true;
        }         
        
    }
    
    public boolean dequeue()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is empty");
            return false;
        }
        
        else
        {
            for(int i=0; i < lastIndex-1; i++)
            {
                stageQueues[i]=stageQueues[i+1];
            }
            lastIndex--;
            length--;
            return true;
        }
                
    }
    
     public boolean isEmpty()
     {
         boolean empty;
         
         if(lastIndex<0)
         {
            empty=true;
            return empty;
         }
            
         else
         {
             empty=false;
             return empty;
         }
             
     }
     
     public boolean isFull()
     {
         return (length==lastIndex+1);
     }
     
     public Q get(int index) {
      return stageQueues[index];
     }
     
     public int getCurrentLevel()
     {
         return currentLevel;
     }
     
     public int getLength()
     {
         return length;
     }
}
