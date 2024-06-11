package com.example.crud.Java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternMatchingSwitchTest {

    // @Test
    // public void testPatternMatchingWithString() {
    //     Object obj = "Hello, Java 17!";
    //     String result = switch (obj) {
    //         case String s -> "It's a string with length: " + s.length();
    //         case Integer i -> "It's an integer with value: " + i;
    //         case null -> "It's null";
    //         default -> "Unknown type";
    //     };
    //     assertEquals("It's a string with length: 14", result);
    // }

    // @Test
    // public void testPatternMatchingWithInteger() {
    //     Object obj = 123;
    //     String result = switch (obj) {
    //         case String s -> "It's a string with length: " + s.length();
    //         case Integer i -> "It's an integer with value: " + i;
    //         case null -> "It's null";
    //         default -> "Unknown type";
    //     };
    //     assertEquals("It's an integer with value: 123", result);
    // }

    // @Test
    // public void testPatternMatchingWithNull() {
    //     Object obj = null;
    //     String result = switch (obj) {
    //         case String s -> "It's a string with length: " + s.length();
    //         case Integer i -> "It's an integer with value: " + i;
    //         case null -> "It's null";
    //         default -> "Unknown type";
    //     };
    //     assertEquals("It's null", result);
    // }

    // @Test
    // public void testPatternMatchingWithGuards() {
    //     Object obj = "Hello, Java 17!";
    //     String result = switch (obj) {
    //         case String s && s.length() > 5 -> "Long string: " + s;
    //         case String s -> "Short string: " + s;
    //         case Integer i && i > 100 -> "Large integer: " + i;
    //         case Integer i -> "Small integer: " + i;
    //         case null -> "It's null";
    //         default -> "Unknown type";
    //     };
    //     assertEquals("Long string: Hello, Java 17!", result);

    //     obj = 150;
    //     result = switch (obj) {
    //         case String s && s.length() > 5 -> "Long string: " + s;
    //         case String s -> "Short string: " + s;
    //         case Integer i && i > 100 -> "Large integer: " + i;
    //         case Integer i -> "Small integer: " + i;
    //         case null -> "It's null";
    //         default -> "Unknown type";
    //     };
    //     assertEquals("Large integer: 150", result);
    // }

    // @Test
    // public void testPatternMatchingWithNestedPatterns() {
    //     Shape shape = new Circle(5.0);
    //     String result = switch (shape) {
    //         case Circle c && c.radius() > 0 -> "Circle with radius: " + c.radius();
    //         case Rectangle r && r.length() > 0 && r.width() > 0 -> "Rectangle with length: " + r.length() + " and width: " + r.width();
    //         default -> "Unknown shape";
    //     };
    //     assertEquals("Circle with radius: 5.0", result);

    //     shape = new Rectangle(10.0, 5.0);
    //     result = switch (shape) {
    //         case Circle c && c.radius() > 0 -> "Circle with radius: " + c.radius();
    //         case Rectangle r && r.length() > 0 && r.width() > 0 -> "Rectangle with length: " + r.length() + " and width: " + r.width();
    //         default -> "Unknown shape";
    //     };
    //     assertEquals("Rectangle with length: 10.0 and width: 5.0", result);
    // }
}

// Supporting classes
sealed interface Shape permits Circle, Rectangle {
}

record Circle(double radius) implements Shape {
}

record Rectangle(double length, double width) implements Shape {
}
