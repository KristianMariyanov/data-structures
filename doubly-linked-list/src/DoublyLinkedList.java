import java.util.Iterator;

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
        throw new UnsupportedOperationException();
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
        return null;
    }
}
