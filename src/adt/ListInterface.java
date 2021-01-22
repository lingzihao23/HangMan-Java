/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Kelly Lai
 */
public interface ListInterface <Q> {
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
    public boolean remove(int i);
    public boolean add(Q item);
    public Q get(int i);
    public boolean contains(Q item);
    public int getSize();
   // public void doubleArray();
}
