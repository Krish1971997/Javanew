package leetcodeZoho8;

class MyHashMap {

    // Node class for linked list
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {

        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node current = buckets[index];

        while (true) {
            if (current.key == key) {
                current.value = value; // update
                return;
            }
            if (current.next == null) 
            	break;
            current = current.next;
        }

        current.next = new Node(key, value);
    }

    public int get(int key) {

        int index = hash(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {

                if (prev == null)
                    buckets[index] = current.next;
                else
                    prev.next = current.next;

                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class DesignHashMapTest {

    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put(1, 1);
        map.put(2, 2);

        System.out.println(map.get(1)); // 1
        System.out.println(map.get(3)); // -1

        map.put(2, 1);
        System.out.println(map.get(2)); // 1

        map.remove(2);
        System.out.println(map.get(2)); // -1
    }
}