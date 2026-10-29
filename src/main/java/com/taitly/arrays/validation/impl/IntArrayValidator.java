package com.taitly.arrays.validation.impl;

import com.taitly.arrays.validation.ArrayValidator;

public class IntArrayValidator implements ArrayValidator {
    private static final String INTEGER_ARRAY_LINE_PATTERN = "\\s*-?[0-9]+(\\s*,\\s*-?[0-9]+)*\\s*";
    private static final String ELEMENT_DELIMITER = ",";

    @Override
    public boolean isValid(String arrayString) {
        if (arrayString == null || arrayString.isBlank()) {
            return false;
        }

        if (!arrayString.matches(INTEGER_ARRAY_LINE_PATTERN)) {
            return false;
        }

        String[] elements = arrayString.split(ELEMENT_DELIMITER);

        for (String element : elements) {
            try {
                Integer.parseInt(element.strip());
            } catch (NumberFormatException exception) {
                return false;
            }
        }

        return true;
    }
}
