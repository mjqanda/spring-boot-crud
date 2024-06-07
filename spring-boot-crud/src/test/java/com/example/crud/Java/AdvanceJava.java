package com.example.crud.Java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class AdvancedJavaTest {

    // Concurrency with CompletableFuture
    @Test
    void completableFutureTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, World!");
        String result = future.thenApply(String::toUpperCase).get();
        System.out.println(result);
        assertEquals("HELLO, WORLD!", result);
    }

    // Using Optional to avoid nulls
    @Test
    void optionalTest() {
        Optional<String> optional = Optional.of("Hello, World!");
        optional.ifPresent(System.out::println);
        assertEquals("HELLO, WORLD!", optional.map(String::toUpperCase).orElse("N/A"));
    }

    // Using Stream to process data
    @Test
    void streamTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> result = strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        result.forEach(System.out::println);
        assertEquals(Arrays.asList("FOUR", "FIVE", "THREE"), result);
    }

    // Using Records
    @Test
    void recordTest() {
        record Person(String name, int age) {
        }

        Person person = new Person("Alice", 30);
        System.out.println(person);
        assertEquals("Alice", person.name());
        assertEquals(30, person.age());
    }

    // Using Map.ofEntries and pattern matching for instanceof
    @Test
    void mapAndPatternMatchingTest() {
        Map<String, Object> map = Map.ofEntries(
                Map.entry("name", "Alice"),
                Map.entry("age", 30),
                Map.entry("height", 5.6));

        map.forEach((key, value) -> {
            if (value instanceof String s) {
                System.out.println(key + " (String): " + s);
            } else if (value instanceof Integer i) {
                System.out.println(key + " (Integer): " + i);
            } else if (value instanceof Double d) {
                System.out.println(key + " (Double): " + d);
            }
        });

        assertEquals("Alice", map.get("name"));
        assertEquals(30, map.get("age"));
        assertEquals(5.6, map.get("height"));
    }

    // Using Enhanced Switch Expression
    @Test
    void enhancedSwitchTest() {
        Day day = Day.WEDNESDAY;
        String typeOfDay = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> "Weekend";
            case TUESDAY -> "Working day";
            case WEDNESDAY, THURSDAY -> "Midweek";
            case SATURDAY -> "Weekend";
        };

        System.out.println("Type of day: " + typeOfDay);
        assertEquals("Midweek", typeOfDay);
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
