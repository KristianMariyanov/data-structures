import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void testAddFirst_emptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(10);

        assertEquals(1, list.getCount());
        assertEquals(10, list.getHead().getValue().intValue());
    }

    @Test
    public void testAddFirst_notEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(30);

        assertEquals(3, list.getCount());
        assertEquals(30, list.getHead().getValue().intValue());
        assertEquals(10, list.getTail().getValue().intValue());
    }

    @Test
    public void testAddLast_emptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addLast(10);

        assertEquals(1, list.getCount());
        assertEquals(10, list.getTail().getValue().intValue());
    }

    @Test
    public void testAddLast_notEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addLast(10);
        list.addLast(5);
        list.addLast(30);

        assertEquals(3, list.getCount());
        assertEquals(30, list.getTail().getValue().intValue());
        assertEquals(10, list.getHead().getValue().intValue());
    }

    @Test
    public void testRemoveFirst_listWithOneElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(10);

        int element = list.removeFirst();

        assertEquals(10, element);
        assertEquals(0, list.getCount());
    }

    @Test
    public void testRemoveFirst_listWithMultipleElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(10);
        list.addFirst(17);
        list.addFirst(1);

        int element = list.removeFirst();
        int element2 = list.removeFirst();

        assertEquals(1, element);
        assertEquals(17, element2);

        assertEquals(1, list.getCount());
    }

    @Test(expected=NoSuchElementException.class)
    public void testRemoveFirst_empltyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.removeFirst();
    }

    @Test
    public void testRemoveLast_listWithOneElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);

        int element = list.removeLast();

        assertEquals(10, element);
        assertEquals(0, list.getCount());
    }

    @Test
    public void testRemoveLast_listWithMultipleElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);
        list.addLast(17);
        list.addLast(1);

        int element = list.removeLast();
        int element2 = list.removeLast();

        assertEquals(1, element);
        assertEquals(17, element2);

        assertEquals(1, list.getCount());
    }

    @Test(expected=NoSuchElementException.class)
    public void testRemoveLast_emptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.removeLast();
    }

    @Test
    public void testIterator_listWithMultipleElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);
        list.addLast(17);

        int[] array = new int[2];
        int index = 0;
        for(Integer element: list) {
            array[index++]= element;
        }

        assertEquals(10, array[0]);
        assertEquals(17, array[1]);
    }

    @Test
    public void testToArray_listWithMultipleElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);
        list.addLast(17);

        Object[] array = list.toArray();

        assertEquals(10, array[0]);
        assertEquals(17, array[1]);
        assertEquals(2, array.length);
    }
}
