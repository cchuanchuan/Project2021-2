

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{
    private Node<Item> first; 	//beginning of the queue
    private Node<Item> last;  	// end of the queue
    private int n; 				// number of elements on queue

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow.");
        return first.item;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow.");
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty()) last = null;
        return item;
    }

    public Iterator<Item> iterator(){
        return new LinkedIterator(first);
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    private class LinkedIterator implements Iterator<Item>{
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
