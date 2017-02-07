import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ryan on 1/31/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] a;

    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for(int i = 0; i < n; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() { return n == 0; }

    public int size() { return n; }

    // add new element and randomize
    public void enqueue(Item item) {
        a[n++] = item;
        if (n == a.length) {
            StdRandom.shuffle(a);
            resize(n * 2);
        }
    }

    public Item dequeue() {
        Item item = a[n-1];
        a[n-1] = null;
        if (n == (a.length/2)) {
            resize(n);
        }
        n--;
        return item;
    }

    public Item sample() {
        return a[n];
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // creates new randomized array to iterate through
    private class ListIterator implements Iterator<Item> {
        private int i;
        Item[] randomized = a;

        public ListIterator() {
            i = n;
        }
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            return randomized[--i];
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
