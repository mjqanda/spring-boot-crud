package com.example.leetcode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {

    @Test
    public void testTwoSum() {
        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        assertArrayEquals(new int[]{0, 1}, result1, "Test case 1 failed");

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        assertArrayEquals(new int[]{1, 2}, result2, "Test case 2 failed");

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        assertArrayEquals(new int[]{0, 1}, result3, "Test case 3 failed");

        // Additional test cases can be added here
    }

    @Test
    public void testTwoSumWithNegativeNumbers() {
        // Test case with negative numbers
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum(nums, target);
        assertArrayEquals(new int[]{2, 4}, result, "Test case with negative numbers failed");
    }

    @Test
    public void testTwoSumWithMixedNumbers() {
        // Test case with mixed positive and negative numbers
        int[] nums = {1, -2, 3, 4, -5, 6};
        int target = 1;
        int[] result = twoSum(nums, target);
        assertArrayEquals(new int[]{1, 5}, result, "Test case with mixed numbers failed");
    }

    @Test
    public void testTwoSumNoSolution() {
        // Test case where no solution should exist, but it won't be used because the problem guarantees one solution
        int[] nums = {1, 2, 3, 4, 5};
        int target = 10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoSum(nums, target);
        });
        String expectedMessage = "No two sum solution";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Test case no solution failed");
    }

    public static int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the number and its index
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            
            // Check if the complement exists in the hash map
            if (numToIndex.containsKey(complement)) {
                // If it exists, return the indices of the complement and the current number
                return new int[] { numToIndex.get(complement), i };
            }
            
            // Otherwise, store the index of the current number in the hash map
            numToIndex.put(num, i);
        }
        
        // Since the problem guarantees exactly one solution, we don't need to handle the case of no solution
        throw new IllegalArgumentException("No two sum solution");
    }
}
