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
        if (isFull()) extendArray();
        elements[++top] = element;
        size++;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        size--;
        return elements[top--];

    }

    public int peek() {
        if (top == -1) {
            return -1;
        }
        return elements[top];
    }


    public int count() {
        return size;
    }

    public void change(int index, int element) {
        if (index < 0 || index > size) {
            return;
        }
        elements[index] = element;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
