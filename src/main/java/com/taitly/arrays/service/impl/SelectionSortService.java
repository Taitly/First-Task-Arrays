package com.taitly.arrays.service.impl;

import com.taitly.arrays.entity.IntArrayEntity;
import com.taitly.arrays.service.ArraySortingService;

public class SelectionSortService implements ArraySortingService {
    @Override
    public void sort(IntArrayEntity array) {
        int[] numbers = array.getArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = temp;
        }

        for (int i = 0; i < numbers.length; i++) {
            array.setValue(i, numbers[i]);
        }
    }
}
