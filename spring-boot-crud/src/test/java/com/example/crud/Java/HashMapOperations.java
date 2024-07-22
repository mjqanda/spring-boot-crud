package com.example.crud.Java;
import java.util.HashMap;

public class HashMapOperations {
    public static <K, V> void insert(HashMap<K, V> map, K key, V value) {
        map.put(key, value);
    }

    public static <K, V> V retrieve(HashMap<K, V> map, K key) {
        return map.get(key);
    }

    public static <K, V> void remove(HashMap<K, V> map, K key) {
        map.remove(key);
    }

    public static <K, V> boolean containsKey(HashMap<K, V> map, K key) {
        return map.containsKey(key);
    }

    public static <K, V> boolean containsValue(HashMap<K, V> map, V value) {
        return map.containsValue(value);
    }

    public static <K, V> int size(HashMap<K, V> map) {
        return map.size();
    }

    public static <K, V> void clear(HashMap<K, V> map) {
        map.clear();
    }
}
