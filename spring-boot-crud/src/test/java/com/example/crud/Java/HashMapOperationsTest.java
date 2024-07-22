package com.example.crud.Java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HashMapOperationsTest {

    @Test
    public void testInsertAndRetrieve() {
        HashMap<Integer, String> map = new HashMap<>();
        HashMapOperations.insert(map, 1, "A");
        HashMapOperations.insert(map, 2, "B");

        assertEquals("A", HashMapOperations.retrieve(map, 1));
        assertEquals("B", HashMapOperations.retrieve(map, 2));
    }

    @Test
    public void testRemove() {
        HashMap<Integer, String> map = new HashMap<>();
        HashMapOperations.insert(map, 1, "A");
        HashMapOperations.insert(map, 2, "B");
        HashMapOperations.remove(map, 1);

        assertNull(HashMapOperations.retrieve(map, 1));
        assertEquals("B", HashMapOperations.retrieve(map, 2));
    }

    @Test
    public void testContainsKeyAndValue() {
        HashMap<Integer, String> map = new HashMap<>();
        HashMapOperations.insert(map, 1, "A");

        assertTrue(HashMapOperations.containsKey(map, 1));
        assertTrue(HashMapOperations.containsValue(map, "A"));

        assertFalse(HashMapOperations.containsKey(map, 2));
        assertFalse(HashMapOperations.containsValue(map, "B"));
    }

    @Test
    public void testSize() {
        HashMap<Integer, String> map = new HashMap<>();
        HashMapOperations.insert(map, 1, "A");
        HashMapOperations.insert(map, 2, "B");

        assertEquals(2, HashMapOperations.size(map));

        HashMapOperations.remove(map, 1);
        assertEquals(1, HashMapOperations.size(map));
    }

    @Test
    public void testClear() {
        HashMap<Integer, String> map = new HashMap<>();
        HashMapOperations.insert(map, 1, "A");
        HashMapOperations.insert(map, 2, "B");

        HashMapOperations.clear(map);
        assertEquals(0, HashMapOperations.size(map));
        assertTrue(map.isEmpty());
    }

    @Test
    public void testSortByValue() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(22, "A");
        map.put(55, "B");
        map.put(33, "Z");
        map.put(44, "M");
        map.put(99, "I");
        map.put(88, "X");

        LinkedHashMap<Integer, String> sortedMap = sortByValue(map);

        List<Map.Entry<Integer, String>> expected = Arrays.asList(
                new AbstractMap.SimpleEntry<>(22, "A"),
                new AbstractMap.SimpleEntry<>(55, "B"),
                new AbstractMap.SimpleEntry<>(99, "I"),
                new AbstractMap.SimpleEntry<>(44, "M"),
                new AbstractMap.SimpleEntry<>(88, "X"),
                new AbstractMap.SimpleEntry<>(33, "Z"));

        List<Map.Entry<Integer, String>> actual = new ArrayList<>(sortedMap.entrySet());

        assertEquals(expected, actual);
    }

    public static <K, V extends Comparable<V>> LinkedHashMap<K, V> sortByValue(HashMap<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        LinkedHashMap<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
