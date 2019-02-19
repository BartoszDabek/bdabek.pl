package com.bdabek.arrays;

import java.util.*;

/**
 * This class contains solutions to find the missing number in a given integer array of 1 to 100.
 */
class MissingNumber {

    private static final int LOWEST_POSSIBLE_VALUE = 1;
    private static final int HIGHEST_POSSIBLE_VALUE = 100;

    /**
     * <pre>
     * The method finds missing number with O(n) cost.
     * It allows to find only one missing number.
     * </pre>
     *
     * @param numbers array of numbers
     * @return missing number in a given integer array of 1 to 100 OR Optional.empty() when missing number is not found
     * @throws IllegalArgumentException when any number in an array is < 1 or > 100
     */
    Optional<Integer> findMissingNumberWithSort(int[] numbers) throws IllegalArgumentException {
        Integer[] sortedArray = sortArray(numbers);

        if (sortedArray[0] < LOWEST_POSSIBLE_VALUE || sortedArray[numbers.length - 1] > HIGHEST_POSSIBLE_VALUE) {
            throw new IllegalArgumentException("Values in array have to be in range between 1 and 100");
        }

        Optional<Integer> missingNumber = getInteger(sortedArray);
        return missingNumber;
    }

    private Integer[] sortArray(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted()
                .toArray(Integer[]::new);
    }

    private Optional<Integer> getInteger(Integer[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            int nextNumber = i + 1;
            if (sortedArray[i] != nextNumber) {
                return Optional.of(nextNumber);
            }
        }
        return Optional.empty();
    }

    /**
     * <pre>
     * The method uses formula that calculates the sum of the series: n * ((n+1) / 2).
     * The cost is O(1).
     * It allows to find only one missing number.
     * </pre>
     *
     * @param numbers   array of numbers
     * @param arraySize expected size of the array
     * @return missing number in a given integer array of 1 to 100 OR Optional.empty() when missing number is not found
     * @throws IllegalArgumentException when any number in an array is < 1 or > 100
     */
    Optional<Integer> findMissingNumberWithFormula(int[] numbers, int arraySize) throws IllegalArgumentException {
        int result = computeDifference(numbers, arraySize);

        if (result == 0) {
            return Optional.empty();
        }

        return Optional.of(result);
    }

    private int computeDifference(int[] numbers, int arraySize) {
        int expectedSum = (int) (arraySize * ((arraySize + 1) / 2.0));
        int actualSum = 0;

        for (int number : numbers) {
            if (number < LOWEST_POSSIBLE_VALUE || number > HIGHEST_POSSIBLE_VALUE) {
                throw new IllegalArgumentException("Values in array have to be in range between 1 and 100");
            }
            actualSum += number;
        }

        return expectedSum - actualSum;
    }

    /**
     * <pre>
     * The method uses <a href="https://docs.oracle.com/javase/8/docs/api/java/util/BitSet.html">BitSet</a> API
     * </pre>
     *
     * @param numbers   array of numbers
     * @param arraySize expected size of the array
     * @return missing number in a given integer array of 1 to 100 OR Collections.Empty() when missing number is not found
     * @throws IllegalArgumentException when any number in an array is < 1 or > 100
     */
    List<Integer> findMissingNumberWithBitSet(int[] numbers, int arraySize) throws IllegalArgumentException {
        List<Integer> missingNumbers = new ArrayList<>();
        int missingCount = arraySize - numbers.length;
        BitSet bitSet = createNotMissingNumberBitSet(numbers, arraySize);

        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            missingNumbers.add(++lastMissingIndex);
        }

        return missingNumbers;
    }

    private BitSet createNotMissingNumberBitSet(int[] numbers, int arraySize) {
        BitSet bitSet = new BitSet(arraySize);
        for (int number: numbers) {
            if (number < LOWEST_POSSIBLE_VALUE || number > HIGHEST_POSSIBLE_VALUE) {
                throw new IllegalArgumentException("Values in array have to be in range between 1 and 100");
            }
            bitSet.set(number - 1);
        }

        return bitSet;
    }
}
