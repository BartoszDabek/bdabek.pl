package com.bdabek.sort.bubble;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    private Integer[] inputData = {54, 2, 28, 71, 87, 62, 67, 58, 93,
            16, 38, 5, 69, 10, 78, 29, 48, 94,
            51, 53, 25, 37, 66, 92, 77, 99, 3,
            6, 64, 72, 52, 95, 41, 90, 18, 91,
            59, 15, 55, 40, 97, 98, 73, 57, 23,
            47, 4, 22, 75, 27, 46, 84, 24, 80,
            79, 42, 34, 88, 30, 96, 8, 12, 61,
            86, 89, 31, 45, 1, 19, 68, 76, 83,
            35, 14, 32, 17, 7, 26, 85, 65, 49,
            81, 50, 11, 63, 39, 74, 100, 56, 21,
            70, 82, 44, 13, 20, 60, 33, 43, 36, 9};

    private Integer[] expectedOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
            50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
            60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
            70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
            80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
            90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
            100};

    @Test
    void testBubbleSorting() {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] result = bubbleSort.sort(inputData);

        assertArrayEquals(expectedOrder, result);
    }
}