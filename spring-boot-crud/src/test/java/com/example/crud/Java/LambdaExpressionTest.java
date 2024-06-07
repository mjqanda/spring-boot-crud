package com.example.crud.Java;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExpressionTest {

    @Test
    void filterTest() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        assertEquals(Collections.singletonList("Alice"), filteredNames);
    }

    @Test
    void mapTest() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(5, 3, 7), nameLengths);
    }

    @Test
    void reduceTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        assertEquals(15, sum);
    }

    @Test
    void sortTest() {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        assertEquals(Arrays.asList("Alice", "Bob", "Charlie"), sortedNames);
    }

    @Test
    void customFunctionalInterfaceTest() {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        assertEquals(5, add.calculate(2, 3));
        assertEquals(6, multiply.calculate(2, 3));
    }

    @Test
    void predicateTest() {
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        assertTrue(isNotEmpty.test("Test"));
        assertFalse(isNotEmpty.test(""));
    }

    @Test
    void functionTest() {
        Function<String, Integer> stringLength = String::length;
        assertEquals(4, stringLength.apply("Test"));
        assertEquals(0, stringLength.apply(""));
    }

    @Test
    void consumerTest() {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        Consumer<List<String>> clearList = List::clear;
        clearList.accept(names);
        assertTrue(names.isEmpty());
    }

    // Custom functional interface
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }
}
