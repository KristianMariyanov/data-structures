import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {
    @Test
    public void testGetCount_emptyQueue() {
        CircularQueue<Integer> stack = new CircularQueue<>();

        assertEquals(0, stack.getCount());
    }

    @Test
    public void testGetCount_oneElementQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(10);

        assertEquals(1, queue.getCount());
    }

    @Test
    public void testGetCount_multipleElementsQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);

        assertEquals(5, queue.getCount());
    }

    @Test
    public void testEnqueue_emptyQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(10);

        assertEquals(1, queue.getCount());
        assertEquals(10, queue.dequeue().intValue());
    }

    @Test
    public void testEnqueue_notEmptyQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(2, queue.getCount());
        assertEquals(10, queue.dequeue().intValue());
        assertEquals(20, queue.dequeue().intValue());
    }

    @Test
    public void testEnqueue_moreElementsThanInitialCapacity() {
        CircularQueue<Integer> queue = new CircularQueue<>(2);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertEquals(5, queue.getCount());
        assertEquals(10, queue.dequeue().intValue());
        assertEquals(20, queue.dequeue().intValue());
        assertEquals(30, queue.dequeue().intValue());
        assertEquals(40, queue.dequeue().intValue());
        assertEquals(50, queue.dequeue().intValue());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeue_emptyQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.dequeue();
    }

    @Test
    public void testDequeue_oneElementQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(20);

        assertEquals(20, queue.dequeue().intValue());
    }

    @Test
    public void testDequeue_multipleElementQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue().intValue());
        assertEquals(20, queue.dequeue().intValue());
        assertEquals(30, queue.dequeue().intValue());
    }
}
