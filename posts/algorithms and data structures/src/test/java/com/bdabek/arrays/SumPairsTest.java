package com.bdabek.arrays;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SumPairsTest {

    @Test
    void shouldFindPairsWithBruteForceThatAreEqualToGivenSum() {
        Map<Integer, List<Integer>> expectedResult = new HashMap<>();
        expectedResult.putIfAbsent(0, List.of(5, 4));
        expectedResult.putIfAbsent(1, List.of(5, 4));
        expectedResult.putIfAbsent(2, List.of(2, 7));
        expectedResult.putIfAbsent(3, List.of(-1, 10));
        expectedResult.putIfAbsent(4, List.of(4, 5));
        expectedResult.putIfAbsent(5, List.of(5, 4));

        int[] array = {5, 2, -1, 4, 3, 5, 7, 12, 10, 4};
        Map<Integer, List<Integer>> foundPairs = new SumPairs().findPairsWithBruteForce(array, 9);

        assertEquals(6, foundPairs.size());
        assertEquals(expectedResult, foundPairs);
    }

    @Test
    void shouldFindPairsWithSetThatAreEqualToGivenSum() {
        Map<Integer, List<Integer>> expectedResult = new HashMap<>();
        expectedResult.putIfAbsent(0, List.of(5, 4));
        expectedResult.putIfAbsent(1, List.of(2, 7));
        expectedResult.putIfAbsent(2, List.of(-1, 10));
        expectedResult.putIfAbsent(3, List.of(5, 4));

        int[] array = {5, 2, -1, 4, 3, 5, 7, 12, 10, 4};
        Map<Integer, List<Integer>> foundPairs = new SumPairs().findPairsWithSet(array, 9);

        assertEquals(4, foundPairs.size());
        assertEquals(expectedResult, foundPairs);
    }

    @Test
    void shouldFindPairsWithPointersThatAreEqualToGivenSum() {
        Map<Integer, List<Integer>> expectedResult = new HashMap<>();
        expectedResult.putIfAbsent(0, List.of(-1, 10));
        expectedResult.putIfAbsent(1, List.of(2, 7));
        expectedResult.putIfAbsent(2, List.of(4, 5));
        expectedResult.putIfAbsent(3, List.of(4, 5));

        int[] array = {5, 2, -1, 4, 3, 5, 7, 12, 10, 4};
        Map<Integer, List<Integer>> foundPairs = new SumPairs().findPairsWithPointers(array, 9);

        assertEquals(4, foundPairs.size());
        assertEquals(expectedResult, foundPairs);
    }

}