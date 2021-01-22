package adt;

public class SortedArrayList<T extends Comparable<? super T>> implements SortedArrayListInterface<T> {

    private T[] rankArray;
    private int length;
    private static final int DEFAULT_CAPACITY = 25;

    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        length = 0;
        rankArray = (T[]) new Comparable[initialCapacity];
    }

    @Override
    public boolean contains(T entry) {
        return containsSeq(entry);
    }

    private boolean binarySearch(int first, int last, T itemNeeded) {
        boolean found;
        int mid = (first + last) / 2;
        if (first > last) {
            found = false;
        } else if (itemNeeded.equals(rankArray[mid])) {
            found = true;
        } else if (itemNeeded.compareTo(rankArray[mid]) < 0) {
            found = binarySearch(first, mid - 1, itemNeeded);
        } else {
            found = binarySearch(mid + 1, last, itemNeeded);
        }
        return found;
    }

    public boolean containsSeq(T entry) {
        boolean result = search(0, length - 1, entry);
        return result;
    }

    private boolean search(int first, int last, T itemNeeded) {
        boolean found;
        if (first > last) {
            found = false;
        } else if (itemNeeded.equals(rankArray[first])) {
            found = true;
        } else {
            found = search(first + 1, last, itemNeeded);
        }
        return found;
    }

    @Override
    public boolean add(T entry) {
        if (isrankArrayFull()) {
            doublerankArray();
        }
        int toIDX, fromIDX;
        for (fromIDX = length - 1, toIDX = fromIDX + 1; (fromIDX >= 0)
                && (entry.compareTo(rankArray[fromIDX]) > 0);// < 0 =  Ascending | >0 = Descending
                toIDX--, fromIDX--) {
            rankArray[toIDX] = rankArray[fromIDX];
        }
        rankArray[toIDX] = entry;
        length++;
        return true;
    }

    @Override
    public boolean remove(T entry) {
        for (int i = 0; i < rankArray.length; i++) {
            if (rankArray[i].equals(entry)) {
                for (int j = i; j < rankArray.length - 1; j++) {
                    rankArray[j] = rankArray[j + 1];
                }
                rankArray[rankArray.length - 1] = null;
                length -= 1;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int index = 0; index < length; index++) {
            rankArray[index] = null;
        }
        length = 0;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < length; i++) {
            str += rankArray[i] + "\n";
        }
        return str;
    }

    private boolean isrankArrayFull() {
        return length == rankArray.length;
    }

    private void doublerankArray() {
        T[] oldList = rankArray;
        int oldSize = oldList.length;

        rankArray = (T[]) new Comparable[2 * oldSize];
        for (int index = 0; index < oldSize; index++) {
            rankArray[index] = oldList[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = length - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            rankArray[index] = rankArray[index + 1];
        }
    }

    @Override
    public T get(int index) {
        return rankArray[index];
    }

}
