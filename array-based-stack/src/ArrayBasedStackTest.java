import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayBasedStackTest {
    @Test
    public void testPush_emptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        stack.push(10);

        assertEquals(1, stack.getCount());
        assertEquals(10, stack.peek().intValue());
    }

    @Test
    public void testPush_notEmptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.getCount());
        assertEquals(20, stack.pop().intValue());
        assertEquals(10, stack.pop().intValue());
    }

    @Test
    public void testPush_moreElementsThanInitialCapacity() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(1);
        stack.push(20);
        stack.push(10);

        assertEquals(2, stack.getCount());
        assertEquals(10, stack.peek().intValue());
    }

    @Test(expected = EmptyStackException.class)
    public void testPop_emptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        stack.pop();
    }

    @Test
    public void testPop_notEmptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop().intValue());
        assertEquals(1, stack.getCount());
        assertEquals(10, stack.pop().intValue());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeek_emptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();
        stack.peek();
    }

    @Test
    public void testPeek_notEmptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek().intValue());
        assertEquals(2, stack.getCount());
    }

    @Test
    public void testIsEmpty_emptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_notEmptyStack() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();

        stack.push(20);

        assertFalse(stack.isEmpty());
    }
}