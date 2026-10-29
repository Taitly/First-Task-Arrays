package com.taitly.arrays.factory;

import com.taitly.arrays.entity.IntArrayEntity;

public interface ArrayFactory {
    IntArrayEntity create(int[] values);
}
