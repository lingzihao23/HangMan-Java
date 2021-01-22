/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Question;
import java.lang.Math;

/**
 *
 * @author lzhao
 */
public class RandomLinkedList<T> implements RandomInterface<T> {

    private Node first;

    private int size = 0;

    public RandomLinkedList() {
        first = null;
    }

    @Override
    public boolean add(T item) {
        
        Node tempNode = new Node(item);
        if (isEmpty()) {
            first = tempNode;
            size++;
        } 
        else if (contains(item))
            return false;
        
        
        else {
            Node currentNode = first;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = tempNode;
            size++;
        }

        return true;
    }
    

    @Override
    public boolean add(T[] item) {
        Node currentNode;
        int i;
    
        if (isEmpty()){
        i=1;
        first = new Node(item[0]);
        size++;
        currentNode=first;
        }
        else {
            i =0;
            currentNode=first;
             while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
        }
         for (;i<item.length;i++){
             if (contains(item[i]))
                 continue;
             currentNode.next= new Node (item[i]);
             currentNode=currentNode.next;
             size++;
             }
  
        
        return true;
    }

    @Override
    public T getRandom() {
        if (isEmpty()) {
            return null;
        }
        T result;
        Node currentNode = first;
        int index = (int) (Math.random() * size);
   
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        result=currentNode.data;
        remove(index);
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T remove(int index) {
        if (index > size ||index <0) {
            return null;
        }

        T result;
        Node tempNode = first;
        
        if (index == 0) {           //remove first element
            result = first.data;
            first = first.next;
            size--;
        }
        

        else {
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.next;
            }
            result = tempNode.next.data;
            tempNode.next = tempNode.next.next;
            size--;
        }

        return result;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        boolean found = false;
        Node entry = new Node (item);
        Node temp = first;
        while (temp.next != null){
            if (temp.data.equals(entry.data)){
                found =true;
                break;
            }
            temp=temp.next;
        }       
       return found;     
    }
    
    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
    
    
}
