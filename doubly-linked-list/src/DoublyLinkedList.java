import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class DoublyLinkedList<T> implements Iterable<T> {

    private int count;

    private ListNode<T> head;

    private ListNode<T> tail;

    public void addFirst(T element) {
        ListNode<T> newElement = new ListNode<>(element);
        if (this.count == 0) {
            this.tail = newElement;
        } else {
            this.head.setPrevNode(newElement);
            newElement.setNextNode(this.head);
        }

        this.head = newElement;
        this.count++;
    }

    public void addLast(T element) {
        ListNode<T> newElement = new ListNode<>(element);
        if (this.count == 0) {
            this.head = newElement;
        } else {
            this.tail.setNextNode(newElement);
            newElement.setPrevNode(this.tail);
        }

        this.tail = newElement;
        this.count++;
    }

    public T removeFirst() {
        T removedElement = null;
        if (this.count == 0) {
            throw new NoSuchElementException("The list is empty.");
        } else if(this.count == 1) {
            removedElement = this.head.getValue();
            this.head = null;
            this.tail = null;
        } else {
            removedElement = this.head.getValue();
            this.head = this.head.getNextNode();
            this.head.setPrevNode(null);
        }

        this.count--;
        return removedElement;
    }

    public T removeLast() {
        T removedElement = null;
        if (this.count == 0) {
            throw new NoSuchElementException("The list is empty.");
        } else if(this.count == 1) {
            removedElement = this.head.getValue();
            this.head = null;
            this.tail = null;
        } else {
            removedElement = this.tail.getValue();
            this.tail = this.tail.getPrevNode();
            this.tail.setNextNode(null);
        }

        this.count--;
        return removedElement;
    }

    public T[] toArray() {
        T[] array = (T[])new Object[this.count];
        ListNode<T> currentElement = this.head;
        for (int i = 0; i < this.count; i++) {
            if (currentElement != null) {
                array[i] = currentElement.getValue();
                currentElement = currentElement.getNextNode();
            } else {
                throw new NullPointerException();
            }
        }

        return array;
    }

    public int getCount() {
        return count;
    }

    public ListNode<T> getHead() {
        return this.head;
    }

    public ListNode<T> getTail() {
        return this.tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ListNode<T> current = head;

        public T next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            T item = current.getValue();
            current = current.getNextNode();
            return item;
        }

        public boolean hasNext() { return current != null; }

        public void remove() { throw new UnsupportedOperationException(); }
    }
}