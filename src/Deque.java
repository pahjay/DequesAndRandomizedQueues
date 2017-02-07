import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ryan on 1/31/17.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public Deque(){
        head = null;
        n = 0;
    }

    // BUG: after removing the only element in a list of size one, the head node does not == null

    public boolean isEmpty(){ return head == null; }
    public int size(){ return n; }

    public void addFirst(Item item){
            Node node = head;
            head = new Node();
            head.item = item;
            head.next = node;
            n++;
    }

    public void addLast (Item item){
        if(head == null){
            head = new Node();
            head.item = item;
            n++;
        } else {
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node();
            node.next.item = item;
            n++;
        }
    }

    public Item removeFirst(){
        if(head == null){
             return null;
        } else {
            Item item = head.item;
            head = head.next;
            n--;
            return item;
        }
    }

    public Item removeLast() {
        if(head == null){
            return null;
        } else {
            Node node = head;
            Node prev = node;

            while (node.next != null){
                prev = node;
                node = node.next;
            }

            Item item = node.item;
            prev.next = null;

            n--;
            return item;
        }
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = head;
        public boolean hasNext(){ return current != null; }
        public void remove(){ throw new UnsupportedOperationException(); }

        public Item next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

}
