package leetcodeZoho2;

public class HashMapExample {
	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		map.put("sachin", 30);
		map.put("sachin", 40);
		map.put("sachin", 50);

		// Verify the entry
		Node<String, Integer> node = map.table[8].next.next;
		System.out.println("Key: " + node.key + ", Value: " + node.value); // Output: Key: sachin, Value: 30
	}
}

class MyHashMap<K, V> {
	Node<K, V>[] table;
	private int capacity = 16; // Default capacity

	public MyHashMap() {
		table = new Node[capacity];
	}

	public void put(K key, V value) {
		int hash = key.hashCode();
		int index = (capacity - 1) & hash;

		Node<K, V> newNode = new Node<>(hash, key, value, null);

		if (table[index] == null) {
			table[index] = newNode;
		} else {
			Node<K, V> current = table[index];
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

}

class Node<K, V> {
	final int hash;
	final K key;
	V value;
	Node<K, V> next;

	Node(int hash, K key, V value, Node<K, V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}
}
