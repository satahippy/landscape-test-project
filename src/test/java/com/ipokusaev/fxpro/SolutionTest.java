package com.ipokusaev.fxpro;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for solution.
 */
class SolutionTest {

    /**
     * Solution to test.
     */
    Solution solution = new Solution();

    @Test
    void example() {
        int[] landscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};
        assertEquals(9, solution.calculateWaterAmount(landscape));
    }

    @Test
    void localHill() {
        int[] landscape = {2, 8, 5, 0, 6, 0, 2, 0 ,8, 0};
        assertEquals(35, solution.calculateWaterAmount(landscape));
    }

    @Test
    void highestInMiddle() {
        int[] landscape = {5, 3, 0, 4, 8, 1, 2};
        assertEquals(9, solution.calculateWaterAmount(landscape));
    }

    @Test
    void hill() {
        int[] landscape = {1, 2, 3, 4, 3, 2, 1};
        assertEquals(0, solution.calculateWaterAmount(landscape));
    }

    @Test
    void flat() {
        int[] landscape = {3, 3, 3, 3, 3, 3, 3};
        assertEquals(0, solution.calculateWaterAmount(landscape));
    }

    @Test
    void empty() {
        int[] landscape = {};
        assertEquals(0, solution.calculateWaterAmount(landscape));
    }

    @Test
    void filled() {
        int[] landscape = new int[32000];
        Arrays.fill(landscape, 32000);
        assertEquals(0, solution.calculateWaterAmount(landscape));
    }

    @Test
    void tooWide() {
        int[] landscape = new int[32001];
        assertThrows(AssertionError.class, () -> solution.calculateWaterAmount(landscape));
    }

    @Test
    void tooHigh() {
        int[] landscape = {0, 32001, 0};
        assertThrows(AssertionError.class, () -> solution.calculateWaterAmount(landscape));
    }

    @Test
    void negativeHeight() {
        int[] landscape = {0, -1, 0};
        assertThrows(AssertionError.class, () -> solution.calculateWaterAmount(landscape));
    }
}