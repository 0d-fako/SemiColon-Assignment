package January2025.Sets;


public class MySet {
    private int[] elements;
    private int size;

    public MySet() {
        elements = new int[10];
        size = 0;
    }

    public void add(int element) {
        if (!contains(element)) {
            if (size == elements.length) {
                extendArray();
            }
            elements[size++] = element;
        }
    }

    public void remove(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                elements[i] = elements[--size];
                return;
            }
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        elements = new int[10];
        size = 0;
    }

    private void extendArray() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MySet { ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

}


