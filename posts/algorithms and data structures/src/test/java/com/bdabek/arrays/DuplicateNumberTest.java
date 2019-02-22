package com.bdabek.arrays;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateNumberTest {

    @Test
    void shouldReturnDuplicatedNumberInArray() {
        int[] array = {5, 2, 1, 4, 3, 5};

        int missingNumber = new DuplicateNumber().findDuplicateNumber(array).get();

        assertEquals(5, missingNumber);
    }

    @Test
    void shouldReturnDuplicatedNumberInArrayWithNegativeNumber() {
        int[] array = {5, -2, 1, -2, 3, 5};

        int missingNumber = new DuplicateNumber().findDuplicateNumber(array).get();

        assertEquals(-2, missingNumber);
    }

    @Test
    void shouldReturnOptionalWhenNoDuplicates() {
        int[] array = {5, 2, 1, 4, 3, 6, 7};

        Optional<Integer> missingNumber = new DuplicateNumber().findDuplicateNumber(array);

        assertEquals(Optional.empty(), missingNumber);
    }

    @Test
    void shouldReturnArrayOfDuplicatedNumber() {
        int[] array = {5, 2, 1, 4, 3, 5};

        List<Integer> missingNumber = new DuplicateNumber().findDuplicateNumbers(array);

        assertEquals(List.of(5), missingNumber);
    }

    @Test
    void shouldReturnArrayOfDuplicatedNumbers() {
        int[] array = {5, -2, 1, -2, 3, 5, 3, 8, 5};

        List<Integer> missingNumber = new DuplicateNumber().findDuplicateNumbers(array);

        assertEquals(List.of(-2, 3, 5), missingNumber);
    }

    @Test
    void shouldReturnEmptyListWhenNoDuplicates() {
        int[] array = {5, 2, 1, 4, 3, 6, 7};

        List<Integer> missingNumber = new DuplicateNumber().findDuplicateNumbers(array);

        assertEquals(Collections.emptyList(), missingNumber);
    }

}