package com.bdabek.sort.bubble;

class BubbleSort {

    <T extends Comparable<T>> T[] sort(T[] array) {
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
