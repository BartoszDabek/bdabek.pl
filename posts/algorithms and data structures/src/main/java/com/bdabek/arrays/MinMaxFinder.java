package com.bdabek.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * This class finds the largest and smallest number from a given input.
 */
class MinMaxFinder {

    /**
     * The method finds min and max number from input int array.
     *
     * @param numbers the input number(s)
     * @return map with min and max number
     * @throws IllegalArgumentException the exception is thrown when passed numbers array is empty
     */
    Map<String, Integer> findMinAndMax(int... numbers) throws IllegalArgumentException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least 1 number required");
        }

        int minNumber = numbers[0];
        int maxNumber = numbers[0];

        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            } else if (number < minNumber) {
                minNumber = number;
            }
        }

        Map<String, Integer> minAndMax = new HashMap<>();
        minAndMax.put("min", minNumber);
        minAndMax.put("max", maxNumber);

        return minAndMax;
    }
}
