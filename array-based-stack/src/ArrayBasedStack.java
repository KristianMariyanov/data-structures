import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
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

    public void push(T element) {
        if (this.count == this.elements.length) {
            this.grow();
        }

        this.elements[this.count++] = element;
    }

    public T pop() {
        if (this.count == 0) {
            throw new EmptyStackException ();
        }

        T removedElement = this.removeLast();
        this.count--;

        return removedElement;
    }

    public T peek() {
        if (this.count == 0) {
            throw new EmptyStackException();
        }

        return this.elements[this.count-1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return this.count;
    }

    public T[] toArray(T[] array) {
        if (array.length < this.count) {
            return (T[]) Arrays.copyOf(this.elements, this.count, array.getClass());
        }

        System.arraycopy(this.elements, 0, array, 0, this.count);
        return array;
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

    private void grow() {
        T[] newElements = (T[])new Object[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, this.count);
        this.elements = newElements;
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
