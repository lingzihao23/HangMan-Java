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
public interface MapInterface <T, Q > {
    public boolean put(T key ,Q value);
    public boolean put(T key);
    public Q getValue(T key);
    public boolean replace (T key,Q newValue);
    public boolean remove (T key);
    public boolean isEmpty();
    public boolean isFull();
    public int getSize();
    public void clear();
    public boolean contains(T key);

}
