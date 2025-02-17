package January2025.Stacks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPopEmptyStack() {
        RuntimeException exception = assertThrows(RuntimeException.class, stack::pop);
        assertEquals("Stack is empty. Cannot pop elements.", exception.getMessage());
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        stack.pop();
        assertEquals(1, stack.peek());
    }

    @Test
    public void testPeekEmptyStack() {
        RuntimeException exception = assertThrows(RuntimeException.class, stack::peek);
        assertEquals("Stack is empty. Cannot peek elements.", exception.getMessage());
    }

    @Test
    public void testCount() {
        assertEquals(0, stack.count());
        stack.push(1);
        assertEquals(1, stack.count());
    }

    @Test
    public void testChange() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.change(2, 4);
        assertEquals(4, stack.peek());
    }

    @Test
    public void testChangeOutOfBounds() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stack.change(3, 4));
        assertEquals("Index out of bounds.", exception.getMessage());
    }


    @Test
    public void testExtendArray() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.count());
    }
}
