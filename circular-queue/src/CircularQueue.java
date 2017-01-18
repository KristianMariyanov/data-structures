import java.util.Arrays;

@SuppressWarnings("unchecked")
public class CircularQueue<T> {
    private final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int startIndex;
    private int endIndex;
    private int count;

    public CircularQueue() { this.elements = (T[]) new Object[INITIAL_CAPACITY]; }

    public CircularQueue(int initialCapacity) { this.elements = (T[]) new Object[initialCapacity]; }

    public int getCount() {
        return count;
    }

    public void enqueue(T element) {
        if(this.count + 1 >= this.elements.length) {
            this.grow();
        }

        this.elements[endIndex] = element;
        endIndex = (endIndex + 1) % this.elements.length;
        this.count++;
    }

    public T dequeue() {
        if (this.count == 0) {
            throw new IllegalStateException("The queue is empty!");
        }

        T element = this.elements[startIndex];
        startIndex = (startIndex + 1) % this.elements.length;
        this.count--;

        return element;
    }

    public T[] toArray(T[] array) {
        if (array.length < this.count) {
            return (T[]) Arrays.copyOf(this.elements, this.count, array.getClass());
        }

        System.arraycopy(this.elements, 0, array, 0, this.count);
        return array;
    }

    private void grow() {
        T[] newElements = (T[])new Object[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, this.count);
        this.elements = newElements;
    }
}
