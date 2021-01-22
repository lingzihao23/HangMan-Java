package adt;

/**
 *
 * @author zichew
 * @param <T>
 */
public interface SortedArrayListInterface<T> {

    public boolean add(T newEntry);

    public boolean remove(T anEntry);

    public boolean contains(T anEntry);

    public void clear();

    public int getLength();

    public boolean isEmpty();

    public boolean isFull();

    public T get(int index);

}
