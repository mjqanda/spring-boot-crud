package com.example.crud.Java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JavaTest {

    @Test
    void arrayListTest() {
        Arrays.asList("0,1,2".split(","))
                .forEach(v -> System.out.println("vid ->" + v));
        assertNull(null);

    }

    @Test
    void hashTest() {
        Map<String, Object> params = new HashMap<>();
        // params.put("VID", "1");

        Object str = params.get("VID");
        String str2 = params.get("VID").toString();
        System.out.println("fdsf");
        assertNull(str);

    }

    @Test
    void mapOfEntriesTest() {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("one", 1),
                Map.entry("two", 2),
                Map.entry("three", 3));

        map.forEach((key, value) -> System.out.println(key + " -> " + value));

        assertEquals(3, map.size());
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

}
