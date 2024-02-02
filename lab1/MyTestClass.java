package lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyTestClass {

	@Test
    public void addFirst() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void addLast() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        assertEquals(1, linkedList.getLast());
    }

    @Test
    public void removeFirst() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.removeFirst();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void removeLast() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.removeLast();
        assertEquals(0, linkedList.size());
    }
}
