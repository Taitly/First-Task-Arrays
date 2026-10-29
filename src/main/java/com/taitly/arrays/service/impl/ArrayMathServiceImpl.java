package com.taitly.arrays.service.impl;

import com.taitly.arrays.entity.IntArrayEntity;
import com.taitly.arrays.service.ArrayMathService;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArrayMathServiceImpl implements ArrayMathService {
    @Override
    public OptionalInt findMax(IntArrayEntity array) {
        if (array == null || array.getLength() == 0) {
            return OptionalInt.empty();
        }

        int[] values = array.getArray();

        int max = values[0];

        for (int i = 1; i < values.length; i++) {
            if (array.getArray()[i] > max) {
                max = array.getArray()[i];
            }
        }
        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt findMin(IntArrayEntity array) {
        if (array == null || array.getLength() == 0) {
            return OptionalInt.empty();
        }

        int[] values = array.getArray();

        int min = values[0];

        for (int i = 1; i < values.length; i++) {
            if (array.getArray()[i] < min) {
                min = array.getArray()[i];
            }
        }
        return OptionalInt.of(min);
    }

    @Override
    public OptionalLong calculateSum(IntArrayEntity array) {
        if (array == null || array.getLength() == 0) {
            return OptionalLong.empty();
        }
        int[] values = array.getArray();

        long sum = 0L;

        for (int value : values) {
            sum += value;
        }

        return OptionalLong.of(sum);
    }

    @Override
    public OptionalDouble calculateAverage(IntArrayEntity array) {
        if (array == null || array.getArray().length == 0) {
            return OptionalDouble.empty();
        }

        int[] values = array.getArray();

        double sum = 0.0;

        for (int value : values) {
            sum += value;
        }

        return OptionalDouble.of(sum/array.getArray().length);
    }
}
