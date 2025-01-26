package January2025.Queue;

public class Queue {
    private int size;
    private String[] elements = new String[3];


    public void enqueue(String element) {
        elements[size++] = element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String element(int i) {
        return elements[i];
    }

    public int size() {
        return size;
    }

    public void dequeue() {
        String[] newElements = new String[elements.length];
        elements[0] = null;
        for (int i = 1; i < size; i++) {
            if (elements[i] != null) {
                newElements[i-1] = elements[i];
            }
        }
        elements = newElements;
        size--;
    }

    public String peek() {
        return elements[0];
    }
}
