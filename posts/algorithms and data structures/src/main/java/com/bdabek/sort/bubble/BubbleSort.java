package com.bdabek.sort.bubble;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.Instant;


class BubbleSort {

    private static final Logger logger = LogManager.getLogger(BubbleSort.class);

    <T extends Comparable<T>> T[] sort(T[] array) {
        Instant start = Instant.now();
        int last = array.length;
        boolean swap;
        do {
            swap = false;
            for (int index = 0; index < last - 1; index++) {
                if (isHigher(array[index], array[index + 1])) {
                    swap = swap(array, index);
                }
            }
            last--;
        } while (swap);
        Instant finish = Instant.now();
        logger.info("Sort method took {}", Duration.between(start, finish).toNanos());
        return array;
    }

    private <T extends Comparable<T>> boolean isHigher(T first, T second) {
        return first.compareTo(second) > 0;
    }

    private <T extends Comparable<T>> boolean swap(T[] array, int index) {
        T currentItem = array[index];
        array[index] = array[index + 1];
        array[index + 1] = currentItem;
        return true;
    }

}
