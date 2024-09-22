package prepinsta;

import java.util.HashMap;

public class CustomHashMap<K, V> extends HashMap<K, V> {

//    public V getOrDefault(K key, V defaultValue) {
//        if (this.containsKey(key)) {
//            return this.get(key);
//        } else {
//            return defaultValue;
//        }
//    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);

        System.out.println(map.getOrDefault("apple", 0));   // Output: 5
        System.out.println(map.getOrDefault("grape", 0));   // Output: 0
        System.out.println(map.getOrDefault("banana", 1));  // Output: 3
        System.out.println(map.getOrDefault("kiwi", 2));    // Output: 2
    }
}
