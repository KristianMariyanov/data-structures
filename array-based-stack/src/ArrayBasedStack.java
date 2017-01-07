import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayBasedStack<T> implements Iterable<T> {
    private final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int count;

    public ArrayBasedStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayBasedStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    public void Push(T element) {
        if (this.count == this.elements.length) {
            this.Grow();
        }

        this.elements[this.count++] = element;
    }

    public T Pop() {
        if (this.count != 0) {
            throw new EmptyStackException ();
        }

        this.count--;
        return this.removeLast();
    }

    public T Peek() {
        return this.elements[this.count-1];
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayBasedStackIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    private T removeLast() {
        T[] newElements = (T[])new Object[this.elements.length];
        System.arraycopy(this.elements, 0, newElements, 0, this.count -1);

        T removedValue = this.elements[this.count-1];
        this.elements = newElements;
        return removedValue;
    }

    private void Grow() {
        T[] newElements = (T[])new Object[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, this.count);
    }

    private class ArrayBasedStackIterator implements Iterator<T> {
        private int currentIndex = count - 1;

        public T next() {
            if (!hasNext()) { throw new EmptyStackException(); }
            T item = elements[currentIndex--];
            return item;
        }

        public boolean hasNext() { return currentIndex != -1; }

        public void remove() { throw new UnsupportedOperationException(); }
    }
}
