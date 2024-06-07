package com.example.crud.Java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Java17Test {

    @Test
    void patternMatchingInstanceofTest() {
        Object obj = "This is a string";

        if (obj instanceof String s) {
            System.out.println("String value: " + s);
            assertEquals("This is a string", s);
        } else {
            fail("Object is not a string");
        }
    }

    @Test
    void enhancedSwitchExpressionTest() {
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

    @Test
    void streamToListTest() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> collectedList = strings.stream()
                .filter(s -> s.length() > 3)
                .toList(); // New toList method

        collectedList.forEach(System.out::println);
        assertEquals(Arrays.asList("three", "four", "five"), collectedList);
    }

    @Test
    void recordTest() {
        record Person(String name, int age) {
        }

        Person person = new Person("Alice", 30);
        System.out.println(person);
        assertEquals("Alice", person.name());
        assertEquals(30, person.age());
    }

    @Test
    void streamMapMultiTest() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> doubledNumbers = strings.stream()
                .<Integer>mapMulti((string, consumer) -> {
                    int number = Integer.parseInt(string);
                    consumer.accept(number * 2);
                })
                .toList(); // New toList method

        doubledNumbers.forEach(System.out::println);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), doubledNumbers);
    }

    @Test
    void textBlockTest() {
        String textBlock = """
                This is a text block.
                It spans multiple lines.
                It's very convenient for multiline strings.
                """;

        System.out.println(textBlock);
        assertTrue(textBlock.contains("multiline"));
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
