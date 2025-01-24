package January2025.Stacks;

public class Stack {
    private int size;
    private int top;
    private int[] elements = new int[3];


    public Stack() {
        size = 0;
        top = -1;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == elements.length;
    }

    private void extendArray() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
    public void push(int element) {
        if(isFull()) extendArray();
        elements[++top] = element;
        size++;
    }

    public int pop() {
        if(top == -1) {
            return -1;
        }
        size--;
        return elements[top--];
        
    }

    public int peek() {
        if(top == -1) {
            return -1;
        }
        return elements[top];
    }



    public push(): When we insert an element in a stack then the operation is known as a push. If the stack is full then the overflow condition occurs.
    pop(): When we delete an element from the stack, the operation is known as a pop. If the stack is empty means that no element exists in the stack, this state is known as an underflow state.
            isEmpty(): It determines whether the stack is empty or not.
            isFull(): It determines whether the stack is full or not.'
    peek(): It returns the element at the given position.
    count(): It returns the total number of elements available in a stack.
            change(): It changes the element at the given position.
    display():
}
