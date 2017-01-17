import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {
    @Test
    public void testGetCount_emptyQueue() {
        CircularQueue<Integer> stack = new CircularQueue<>();

        assertEquals(0, stack.getCount());
    }

    @Test
    public void testEnqueue_emptyQueue() {
        CircularQueue<Integer> stack = new CircularQueue<>();

        stack.enqueue(10);

        assertEquals(1, stack.getCount());
        assertEquals(10, stack.dequeue().intValue());
    }

    @Test
    public void testEnqueue_notEmptyQueue() {
        CircularQueue<Integer> stack = new CircularQueue<>();

        stack.enqueue(10);
        stack.enqueue(20);

        assertEquals(2, stack.getCount());
        assertEquals(20, stack.dequeue().intValue());
        assertEquals(10, stack.dequeue().intValue());
    }
}
