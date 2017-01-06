import java.util.Iterator;
import java.util.Spliterator;
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
        throw new UnsupportedOperationException();
    }

    public T Pop() {
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }
}
