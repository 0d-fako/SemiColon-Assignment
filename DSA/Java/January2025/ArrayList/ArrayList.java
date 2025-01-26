package January2025.ArrayList;

public class ArrayList {
    private String[] elements = new String[4];
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String element) {
        if (isFull()) extendArray();
        elements[size++] = element;
    }

    private void extendArray() {
        String[] newElements = new String[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    private boolean isFull() {
        return size == elements.length;
    }

    public String get(int i) {
        return elements[i];
    }

    public int size() {
        return size;
    }

    public void remove(String element) {
        int elementIndex = findElementIndex(element);
        if (elementIndex != -1) {
            elements[elementIndex] = null;
            addOldElementToNewArray(elementIndex);
            size--;
        }
    }

    private void addOldElementToNewArray(int elementIndex) {
        String[] newElements = new String[elements.length];
        for (String element : elements) {
            if (element != null) {
                newElements[elementIndex] = element;
            }
        }
        elements = newElements;
    }

    private int findElementIndex(String element) {
        for (int i = 0; i < elements.length; i++) if (elements[i].equals(element)) return i;
        return -1;
    }




    public void clear() {
        size = 0;
        elements = new String[3];
    }

    public int indexOf(String element) {
        return findElementIndex(element);
    }

    public void add(int index, String element) {
        String[] newElements = new String[elements.length];
        if (index >= 0) System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = element;

        if (size - index >= 0) System.arraycopy(elements, index, newElements, index + 1, size - index);
        elements = newElements;
        size++;
    }

}