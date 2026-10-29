package com.taitly.arrays.entity;

import java.util.Arrays;

public class IntArrayEntity {
    private final int[] values;

    public IntArrayEntity(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(values, values.length);
    }

    public void setValue(int index, int value) {
        values[index] = value;
    }

    public int getLength() {
        return values.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntArrayEntity objArray = (IntArrayEntity) obj;

        return Arrays.equals(values, objArray.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return new StringBuilder("IntArrayEntity{")
                .append("values=")
                .append(Arrays.toString(values))
                .append('}')
                .toString();
    }
}
