package geeksforgeeksZoho;

import java.util.Arrays;

class CustomArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public CustomArrayList() {
        this.array = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
        System.out.println(element + " added to the ArrayList.");
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
        return (T) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
        System.out.println(array[index] + " removed from the ArrayList.");
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("ArrayList is empty.");
            return;
        }
        System.out.print("ArrayList: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
    }
}

public class ArrayList {
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        arrayList.print();
        System.out.println("Current ArrayList size: " + arrayList.size());
        System.out.println("Element at index 1: " + arrayList.get(1));

        arrayList.remove(1);
        arrayList.print();

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());
    }

	public void add(ElementFrequency elementFrequency) {
		// TODO Auto-generated method stub
		
	}
}
