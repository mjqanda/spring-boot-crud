package com.example.crud.Java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Java17SwitchTest {

    @Test
    void basicEnhancedSwitchTest() {
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
    void switchWithYieldTest() {
        int month = 8;
        int daysInMonth = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28; // For simplicity, not accounting for leap years here
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };

        System.out.println("Days in month: " + daysInMonth);
        assertEquals(31, daysInMonth);
    }

    @Test
    void switchWithComplexYieldTest() {
        String status = "open";
        String message = switch (status) {
            case "open" -> "The door is open.";
            case "closed" -> "The door is closed.";
            case "locked" -> {
                // More complex block
                yield "The door is locked.";
            }
            default -> {
                yield "Unknown status: " + status;
            }
        };

        System.out.println(message);
        assertEquals("The door is open.", message);
    }

    @Test
    void switchWithEnumTest() {
        Priority priority = Priority.HIGH;
        String message = switch (priority) {
            case HIGH -> "This is a high priority task.";
            case MEDIUM -> "This is a medium priority task.";
            case LOW -> "This is a low priority task.";
        };

        System.out.println(message);
        assertEquals("This is a high priority task.", message);
    }

    @Test
    void switchInMethodTest() {
        assertEquals("Winter", getSeason(Month.DECEMBER));
        assertEquals("Summer", getSeason(Month.JUNE));
        assertEquals("Fall", getSeason(Month.SEPTEMBER));
    }

    // @Test
    // void switchWithPatternMatchingTest() { //java 21
    //     Object obj = "Hello, World!";
    //     String result = switch (obj) {
    //         case String s -> "String: " + s;
    //         case Integer i -> "Integer: " + i;
    //         case Double d -> "Double: " + d;
    //         default -> "Unknown type";
    //     };

    //     System.out.println(result);
    //     assertEquals("String: Hello, World!", result);
    // }

    @Test
    void switchWithMultipleStatementsTest() {
        int dayOfWeek = 5;
        String message = switch (dayOfWeek) {
            case 1 -> "Monday: Start of the work week!";
            case 2 -> "Tuesday: Second day.";
            case 3 -> {
                System.out.println("It's Wednesday.");
                yield "Wednesday: Midweek.";
            }
            case 4 -> "Thursday: Almost the weekend.";
            case 5 -> {
                System.out.println("It's Friday.");
                yield "Friday: End of the work week!";
            }
            case 6, 7 -> "Weekend: Relax!";
            default -> "Invalid day.";
        };

        System.out.println(message);
        assertEquals("Friday: End of the work week!", message);
    }

    @Test
    void switchWithReturnStatementTest() {
        assertEquals("Monday", getDayType(1));
        assertEquals("Wednesday", getDayType(3));
        assertEquals("Saturday", getDayType(6));
        assertEquals("Invalid day", getDayType(8));
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum Priority {
        HIGH, MEDIUM, LOW
    }

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    private String getSeason(Month month) {
        return switch (month) {
            case DECEMBER, JANUARY, FEBRUARY -> "Winter";
            case MARCH, APRIL, MAY -> "Spring";
            case JUNE, JULY, AUGUST -> "Summer";
            case SEPTEMBER, OCTOBER, NOVEMBER -> "Fall";
        };
    }

    private String getDayType(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
    }
}
