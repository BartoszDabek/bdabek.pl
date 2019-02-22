package com.bdabek.arrays;

import java.util.*;

/**
 * This class contains solution(s) to find the duplicated number on a given integer array
 */
class DuplicateNumber {

    /**
     * <pre>
     *     The method finds duplicate number on a given array with O(n) cost.
     *     It allows to find only first duplicated number.
     * </pre>
     *
     * @param numbers array of numbers
     * @return first duplicated number in a given integer array OR Optional.empty() when duplicates are not found
     */
    Optional<Integer> findDuplicateNumber(int[] numbers) {
        Arrays.sort(numbers);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i-1] == numbers[i]) {
                return Optional.of(numbers[i]);
            }
        }

        return Optional.empty();
    }

    /**
     * This method finds duplicated numbers on a given array.
     *
     * @param numbers array of numbers
     * @return list of duplicated numbers OR empty list when duplicates are not found
     */
    List<Integer> findDuplicateNumbers(int[] numbers) {
        Arrays.sort(numbers);
        Set<Integer> duplicates = new HashSet<>();

        int previous = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            int next = numbers[i];

            if (previous == next) {
                duplicates.add(next);
            }
            previous = next;
        }

        return new ArrayList<>(duplicates);
    }

}
