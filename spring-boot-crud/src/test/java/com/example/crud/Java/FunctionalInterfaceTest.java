package com.example.crud.Java;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfaceTest {

    @Test
    void binaryOperationTest() {
        BinaryOperation addition = (a, b) -> a + b;
        BinaryOperation multiplication = (a, b) -> a * b;
        BinaryOperation subtraction = (a, b) -> a - b;

        assertEquals(5, addition.apply(2, 3));
        assertEquals(6, multiplication.apply(2, 3));
        assertEquals(1, subtraction.apply(3, 2));
    }

    @Test
    void stringManipulatorTest() {
        StringManipulator toUpperCase = String::toUpperCase;
        StringManipulator reverse = s -> new StringBuilder(s).reverse().toString();
        StringManipulator addPrefix = s -> "Prefix_" + s;

        assertEquals("HELLO", toUpperCase.manipulate("hello"));
        assertEquals("olleh", reverse.manipulate("hello"));
        assertEquals("Prefix_hello", addPrefix.manipulate("hello"));
    }

    @Test
    void conditionTest() {
        Condition<Integer> isEven = n -> n % 2 == 0;
        Condition<String> isNotEmpty = s -> !s.isEmpty();
        Condition<Integer> isPositive = n -> n > 0;

        assertTrue(isEven.test(4));
        assertFalse(isEven.test(3));
        assertTrue(isNotEmpty.test("test"));
        assertFalse(isNotEmpty.test(""));
        assertTrue(isPositive.test(5));
        assertFalse(isPositive.test(-5));
    }

    // Custom functional interfaces
    @FunctionalInterface
    interface BinaryOperation {
        int apply(int a, int b);
    }

    @FunctionalInterface
    interface StringManipulator {
        String manipulate(String s);
    }

    @FunctionalInterface
    interface Condition<T> {
        boolean test(T t);
    }
}
