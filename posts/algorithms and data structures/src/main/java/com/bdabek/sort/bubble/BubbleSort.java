package com.bdabek.sort.bubble;

class BubbleSort {


    Integer[] sort(Integer[] inputData) {
        int arrayLength = inputData.length;

        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (inputData[j] > inputData[j+1]) {
                    int temp = inputData[j];
                    inputData[j] = inputData[j+1];
                    inputData[j+1] = temp;
                }
            }
        }
        return inputData;
    }
}
