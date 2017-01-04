import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testAddLast_notEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addLast(10);
        list.addLast(5);
        list.addLast(30);

        assertEquals(3, list.getCount());
        assertEquals(30, list.getTail().getValue().intValue());
        assertEquals(10, list.getHead().getValue().intValue());
    }
}