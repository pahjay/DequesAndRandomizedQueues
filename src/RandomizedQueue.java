import java.util.Iterator;

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
        if(n == (a.length * 3/4)) resize(n * 2);
        a[n++] = item;
    }

    public Item dequeue() {
        int random = (int) (Math.random() * n);
        Item item = a[random-1];
        a[random-1] = null;
        n--;
        if(n == (a.length/4)) resize (n / 2);
        return item;
    }

    public Item sample() {
        int random = 0;
        while(a[random] != null) {
            random = (int) (Math.random() * n);
            Item item = a[random];
            return item;
        }
    }

    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator {

    }
}
