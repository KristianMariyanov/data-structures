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
        return this.removeLast();
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    private T removeLast() {
        T[] newElements = (T[])new Object[this.elements.length];
        System.arraycopy(this.elements, 0, newElements, 0, this.count -1);

        T removedValue = this.elements[this.count];
        this.elements = newElements;
        return removedValue;
    }

    private void Grow() {
        T[] newElements = (T[])new Object[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, this.count);
    }
}
