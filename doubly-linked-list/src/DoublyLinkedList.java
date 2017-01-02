import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int count;

    private ListNode<T> head;

    private ListNode<T> tail;

    public void AddFirst(T element) {
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

    public void AddLast(T element) {
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

    public T RemoveFirst() {
        throw new UnsupportedOperationException();
    }

    public T RemoveLast() {
        throw new UnsupportedOperationException();
    }

    public T[] ToArray() {
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return count;
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
