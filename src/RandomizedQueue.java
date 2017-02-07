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


    public void enqueue(Item item) {
        a[n++] = item;
        if (n == a.length) {
            StdRandom.shuffle(a);
            resize(n * 2);
        }
    }

    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException();
        } else {
            Item item = a[n - 1];
            a[n - 1] = null;

            if (n == (a.length / 2)) {
                resize(n);
            }

            n--;
            return item;
        }
    }

    public Item sample() {
        if (n == 0) {
            throw new NoSuchElementException();
        } else {
            return a[StdRandom.uniform(n-1)];
        }
    }

    public Iterator<Item> iterator() {
        resize(n);
        StdRandom.shuffle(a);
        return new ListIterator();
    }

    // creates new randomized array to iterate through
    private class ListIterator implements Iterator<Item> {
        private int i;
        Item[] randomized = a;

        public ListIterator() {
            i = 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return randomized[i++];
            }
        }

        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
