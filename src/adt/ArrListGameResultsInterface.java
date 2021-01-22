/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author OWNER
 */
public interface ArrListGameResultsInterface <G> {
  
    public boolean add(G newEntry);
    public boolean replace(int givenPos, G newEntry);
    public G getEntry(int givenPos);
    public G get(int index);
    public int getLength();
    public boolean isFull();
    public boolean isEmpty();
    public void copyArray(int size,String action);
    public int increaseArraySize(int size, String action);
}
