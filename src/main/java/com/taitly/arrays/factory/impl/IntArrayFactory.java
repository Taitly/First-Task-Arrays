package com.taitly.arrays.factory.impl;

import com.taitly.arrays.entity.IntArrayEntity;
import com.taitly.arrays.factory.ArrayFactory;

public final class IntArrayFactory implements ArrayFactory {
    @Override
    public IntArrayEntity create(int[] values) {
        return new IntArrayEntity(values);
    }
}
