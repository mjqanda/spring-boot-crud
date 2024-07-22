package com.example.crud.Java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.example.crud.model.Item;

class JavaStreamTest {

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
        if (str != null) {
            String str2 = str.toString();
        }
        System.out.println("fdsf");
        assertNull(str);
    }

    @Test
    void streamFilterTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> filtered = strings.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);
        assertEquals(Arrays.asList("three", "four", "five"), filtered);
    }

    @Test
    void streamMapTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<Integer> lengths = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        lengths.forEach(System.out::println);
        assertEquals(Arrays.asList(3, 3, 5, 4, 4), lengths);
    }

    @Test
    void streamReduceTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        assertEquals(15, sum);

        List<Item> items = Arrays.asList(
                new Item("Item1", 10, 9.99),
                new Item("Item2", 5, 19.99),
                new Item("Item3", 15, 29.99));

        // Calculate the total quantity using reduce
        int totalQty = items.stream()
                .map(Item::getQty)
                .reduce(0, Integer::sum);

        // Calculate the total price using reduce
        double totalPrice = items.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);

        // Print the results
        System.out.println("Total Quantity: " + totalQty);
        System.out.println("Total Price: " + totalPrice);

    }

    @Test
    void streamSortTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> sorted = strings.stream()
                .sorted()
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        assertEquals(Arrays.asList("five", "four", "one", "three", "two"), sorted);
    }

    @Test
    void streamDistinctTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "two", "one");
        List<String> distinct = strings.stream()
                .distinct()
                .collect(Collectors.toList());
        distinct.forEach(System.out::println);
        assertEquals(Arrays.asList("one", "two", "three"), distinct);
    }

    @Test
    void streamLimitTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> limited = strings.stream()
                .limit(3)
                .collect(Collectors.toList());
        limited.forEach(System.out::println);

        // String str = strings.stream().filter()
        // String str = strings.get(1);
        assertEquals(Arrays.asList("one", "two", "three"), limited);
    }

    @Test
    void streamSkipTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> skipped = strings.stream()
                .skip(2)
                .collect(Collectors.toList());
        skipped.forEach(System.out::println);
        assertEquals(Arrays.asList("three", "four", "five"), skipped);
    }

    @Test
    void streamIntStreamTest() {
        IntStream.range(1, 6)
                .forEach(System.out::println);
        assertEquals(15, IntStream.range(1, 6).sum());
    }

    @Test
    void streamFlatMapTest() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five"));

        List<String> flatList = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        flatList.forEach(System.out::println);
        assertEquals(Arrays.asList("one", "two", "three", "four", "five"), flatList);
    }

}
