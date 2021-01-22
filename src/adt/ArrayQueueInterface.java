
package adt;

public interface ArrayQueueInterface <Q> {
    
    public boolean enqueue(Q newEntry);
    public boolean dequeue();
    public boolean isEmpty();
    public boolean isFull();
    public int getCurrentLevel();
    public int getLength();
    public Q get(int index);
    
}
