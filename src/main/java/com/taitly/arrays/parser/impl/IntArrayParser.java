package com.taitly.arrays.parser.impl;

import com.taitly.arrays.parser.ArrayParser;


public class IntArrayParser implements ArrayParser {
    private static final String ELEMENT_DELIMITER = ",";

    @Override
    public int[] parse(String arrayString) {
        String[] elements = arrayString.split(ELEMENT_DELIMITER);
        int[] numbers = new int[elements.length];

        for (int i = 0; i < numbers.length; i++) {
            String element = elements[i].strip();
            numbers[i] = Integer.parseInt(element);
        }

        return numbers;
    }
}
