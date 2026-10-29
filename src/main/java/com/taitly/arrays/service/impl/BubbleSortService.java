package com.taitly.arrays.service.impl;

import com.taitly.arrays.entity.IntArrayEntity;
import com.taitly.arrays.service.ArraySortingService;

public class BubbleSortService implements ArraySortingService {
    @Override
    public void sort(IntArrayEntity array) {
        int[] numbers = array.getArray();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            array.setValue(i, numbers[i]);
        }
    }
}
