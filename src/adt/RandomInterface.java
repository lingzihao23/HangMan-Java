/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Question;

/**
 *
 * @author lzhao
 */
public interface RandomInterface <T> {
    public boolean add(T item);
    public boolean add(T []item);
    public T getRandom();
    public int getSize();
    public T remove(int i);
    public void clear();
    public boolean isEmpty();
    public boolean isFull();
    public boolean contains(T item);
 
}
