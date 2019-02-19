package com.bdabek.arrays;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MissingNumberTest {

    @Test
    @Tag("Sort")
    void shouldThrowErrorWhenNegativeNumberInArray() {
        int[] array = {5, 2, -1, 100, 20};

        assertThrows(IllegalArgumentException.class,
                () -> new MissingNumber().findMissingNumberWithSort(array));
    }

    @Test
    @Tag("Sort")
    void shouldThrowErrorWhenNumberHigherThan100InArray() {
        int[] array = {5, 2, 1, 102, 20};

        assertThrows(IllegalArgumentException.class,
                () -> new MissingNumber().findMissingNumberWithSort(array));
    }

    @Test
    @Tag("Sort")
    void shouldReturnMissingNumberWhichIsEqualTo7() {
        int[] array = {5, 2, 1, 4, 3, 9, 6, 8, 10};

        int missingNumber = new MissingNumber().findMissingNumberWithSort(array).get();

        assertEquals(7, missingNumber);
    }

    @Test
    @Tag("Sort")
    void shouldReturnOptionalWhenArrayIsComplete() {
        int[] array = {5, 2, 1, 4, 3, 9, 6, 8, 10, 7};

        Optional<Integer> missingNumber = new MissingNumber().findMissingNumberWithSort(array);

        assertEquals(Optional.empty(), missingNumber);
    }

    @Test
    @Tag("Formula")
    void shouldThrowErrorWhenNegativeNumberInArrayWithFormula() {
        int[] array = {5, 2, -1, 100, 20};

        assertThrows(IllegalArgumentException.class,
                () -> new MissingNumber().findMissingNumberWithFormula(array, 5));
    }

    @Test
    @Tag("Formula")
    void shouldThrowErrorWhenNumberHigherThan100InArrayWithFormula() {
        int[] array = {5, 2, 1, 102, 20};

        assertThrows(IllegalArgumentException.class,
                () -> new MissingNumber().findMissingNumberWithFormula(array, 5));
    }

    @Test
    @Tag("Formula")
    void shouldReturnMissingNumberWithFormulaWhichIsEqualTo7() {
        int[] array = {5, 2, 1, 4, 3, 9, 6, 8, 10};

        int missingNumber = new MissingNumber().findMissingNumberWithFormula(array, 10).get();

        assertEquals(7, missingNumber);
    }

    @Test
    @Tag("Formula")
    void shouldReturnOptionalWithFormulaWhenArrayIsComplete() {
        int[] array = {5, 2, 1, 4, 3, 9, 6, 8, 10, 7};

        Optional<Integer> missingNumber = new MissingNumber().findMissingNumberWithFormula(array, 10);

        assertEquals(Optional.empty(), missingNumber);
    }

    @Test
    @Tag("BitSet")
    void shouldThrowErrorWhenNegativeNumberInArrayWithBitSet() {
        int[] array = {5, 2, -1, 100, 20};

        assertThrows(IllegalArgumentException.class,
                () -> new MissingNumber().findMissingNumberWithBitSet(array, 5));
    }

    @Test
    @Tag("BitSet")
    void shouldThrowErrorWhenNumberHigherThan100InArrayWithBitSet() {
        int[] array = {5, 2, 1, 102, 20};

        assertThrows(IllegalArgumentException.class,
                () -> new MissingNumber().findMissingNumberWithBitSet(array, 5));
    }

    @Test
    @Tag("BitSet")
    void shouldReturnMissingNumberWithBitSetWhichIsEqualTo7() {
        int[] array = {5, 2, 1, 4, 3, 9, 6, 8, 10};

        List<Integer> missingNumber = new MissingNumber().findMissingNumberWithBitSet(array, 10);

        assertEquals(List.of(7), missingNumber);
    }

    @Test
    @Tag("BitSet")
    void shouldReturnTwoMissingNumbersWithBitSet() {
        int[] array = {5, 2, 1, 3, 9, 6, 8, 10};

        List<Integer> missingNumbers = new MissingNumber().findMissingNumberWithBitSet(array, 10);

        assertEquals(List.of(4, 7), missingNumbers);
    }

    @Test
    @Tag("BitSet")
    void shouldReturnFiveMissingNumbersWithBitSet() {
        int[] array = {2, 3, 6, 8, 10};

        List<Integer> missingNumbers = new MissingNumber().findMissingNumberWithBitSet(array, 10);

        assertEquals(List.of(1, 4, 5, 7, 9), missingNumbers);
    }

    @Test
    @Tag("BitSet")
    void shouldReturnOptionalWithBitSetWhenArrayIsComplete() {
        int[] array = {5, 2, 1, 4, 3, 9, 6, 8, 10, 7};

        List<Integer> missingNumber = new MissingNumber().findMissingNumberWithBitSet(array, 10);

        assertEquals(Collections.emptyList(), missingNumber);
    }
}