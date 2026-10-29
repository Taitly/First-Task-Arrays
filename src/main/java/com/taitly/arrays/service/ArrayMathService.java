package com.taitly.arrays.service;

import com.taitly.arrays.entity.IntArrayEntity;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayMathService {
    OptionalInt findMax(IntArrayEntity array);

    OptionalInt findMin(IntArrayEntity array);

    OptionalLong calculateSum(IntArrayEntity array);

    OptionalDouble calculateAverage(IntArrayEntity array);
}
