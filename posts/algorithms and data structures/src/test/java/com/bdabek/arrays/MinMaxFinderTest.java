package com.bdabek.arrays;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MinMaxFinderTest {

    @Test
    void shouldReturnExceptionWhenEmptyArrayPassed() {
        assertThrows(IllegalArgumentException.class,
                () -> new MinMaxFinder().findMinAndMax(new int[] {}));
    }
    
    @Test
    void shouldFindTheMinAndMax() {
        int[] array = {5, 2, -1, 4, 3, 5};

        Map<String, Integer> minAndMax = new MinMaxFinder().findMinAndMax(array);

        assertEquals(-1, minAndMax.get("min"));
        assertEquals(5, minAndMax.get("max"));
    }

    @Test
    void shouldFindTheMinAndMax1() {
        int[] array = {1, 2, 3};

        Map<String, Integer> minAndMax = new MinMaxFinder().findMinAndMax(array);

        assertEquals(1, minAndMax.get("min"));
        assertEquals(3, minAndMax.get("max"));
    }

    @Test
    void shouldFindTheMinAndMax2() {
        int[] array = {1};

        Map<String, Integer> minAndMax = new MinMaxFinder().findMinAndMax(array);

        assertEquals(1, minAndMax.get("min"));
        assertEquals(1, minAndMax.get("max"));
    }

    @Test
    void shouldFindTheMinAndMax3() {
        int[] array = {-10, 10};

        Map<String, Integer> minAndMax = new MinMaxFinder().findMinAndMax(array);

        assertEquals(-10, minAndMax.get("min"));
        assertEquals(10, minAndMax.get("max"));
    }

    @Test
    void shouldFindTheMinAndMax4() {
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        Map<String, Integer> minAndMax = new MinMaxFinder().findMinAndMax(array);

        assertEquals(Integer.MIN_VALUE, minAndMax.get("min"));
        assertEquals(Integer.MAX_VALUE, minAndMax.get("max"));
    }
}