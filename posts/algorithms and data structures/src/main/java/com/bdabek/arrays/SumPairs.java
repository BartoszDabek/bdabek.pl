package com.bdabek.arrays;

import java.util.*;

/**
 * The class find pairs on integer array whose sum is equal to a given number
 */
class SumPairs {

    /**
     * The method finds pairs on integer array whose sum is equal to a given number with O(n^2) cost.
     *
     * @param numbers   array of integer numbers
     * @param sumNumber given sum
     * @return map where key is equal to pair counter and value is a pair
     */
    Map<Integer, List<Integer>> findPairsWithBruteForce(int[] numbers, int sumNumber) {
        Map<Integer, List<Integer>> pairs = new HashMap<>();
        int pairCounter = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sumNumber) {
                    pairs.putIfAbsent(pairCounter++, List.of(numbers[i], numbers[j]));
                }
            }
        }
        return pairs;
    }

    /**
     * <p>
     * The method finds pairs on integer array whose sum is equal to a given number with O(n) cost.
     * It requires additional space of order O(n) to store numbers in Set. Due to that it's low efficient when
     * given array is huge.
     * </p>
     *
     * @param numbers   array of integer numbers
     * @param sumNumber given sum
     * @return map where key is equal to pair counter and value is a pair
     */
    Map<Integer, List<Integer>> findPairsWithSet(int[] numbers, int sumNumber) {
        Map<Integer, List<Integer>> pairs = new HashMap<>();
        int pairCounter = 0;

        Set<Integer> tempNumbers = new HashSet<>(numbers.length);
        for (int number : numbers) {
            int target = sumNumber - number;

            if (!tempNumbers.contains(target)) {
                tempNumbers.add(number);
            } else {
                pairs.putIfAbsent(pairCounter++, List.of(target, number));
            }
        }
        return pairs;
    }

    /**
     * <p>
     * The method finds pairs on integer array whose sum is equal to a given number with O(n log n) cost.
     * </p>
     *
     * <pre>
     *     Using two pointers to scan through array from both direction i.e. beginning and end.
     *     If sum of both values are equal to a given number then adds the pair and advance pointers.
     *     If the sum of two numbers is less than given number then increase the left pointer,
     *     else if the sum is greater than given number decrement the right pointer.
     *     Repeat until both pointers meet at some part of the array.
     * </pre>
     *
     * @param numbers   array of integer numbers
     * @param sumNumber given sum
     * @return map where key is equal to pair counter and value is a pair
     */
    Map<Integer, List<Integer>> findPairsWithPointers(int[] numbers, int sumNumber) {
        Arrays.sort(numbers);
        Map<Integer, List<Integer>> pairs = new HashMap<>();
        int pairCounter = 0;

        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];

            if (sum == sumNumber) {
                pairs.putIfAbsent(pairCounter++, List.of(numbers[leftPointer], numbers[rightPointer]));
                leftPointer++;
                rightPointer--;
            } else if (sum < sumNumber) {
                leftPointer++;
            } else if (sum > sumNumber) {
                rightPointer--;
            }
        }

        return pairs;
    }
}
