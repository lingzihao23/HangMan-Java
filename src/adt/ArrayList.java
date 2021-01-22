/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.*;
import entity.User;

/**
 *
 * @author Kelly Lai
 */
public class ArrayList<Q> implements ListInterface<Q> {

    private Q[] list;
    private int size;
    private final static int CAPACITY = 10;

    public ArrayList() {

        size = 0;
        list = (Q[]) new Object[CAPACITY];
    }

    @Override
    public boolean add(Q item) {

        //if they are the same
        
        if (isFull() == true) {
            return false;
        }

        if (contains(item) == true) {
            return false;
        } //if they are the same
        
        list[size] = item;
        size++;
        return true;

    }

    @Override
    public boolean isEmpty() {
        if (size < 0) {
            System.out.println("List is empty");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        list = null;
        size = 0;
    }

    @Override
    public boolean remove(int x) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(list[x])) {
                list[i]=null;
                for (int y = i; y < size; y++) {
                    list[y] = list[y + 1];
                }
                list[size - 1] = null;
                size -=1;
                return true;
            }
        }
        return false;
    }

    @Override
    public Q get(int i) {
        return list[i];
    }

    @Override
    public boolean contains(Q item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

//    @Override
//    public void doubleArray() {
//        Q[] oldArray = list;
//        int oldSize = oldArray.length;
//        list = (Q[]) new Object[oldSize * 2];
//        for (int i = 0; i < oldSize; i++) {
//            list[i] = oldArray[i];
//        }//end of for loop
//        capacity = capacity * 2;
//    }
    @Override
    public boolean isFull() {
        if (CAPACITY == size + 1) {
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" + "list=" + list + ", size=" + size + '}';
    }

}
