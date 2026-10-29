package com.taitly.arrays.main;

import com.taitly.arrays.entity.IntArrayEntity;
import com.taitly.arrays.exception.CustomException;
import com.taitly.arrays.factory.ArrayFactory;
import com.taitly.arrays.factory.impl.IntArrayFactory;
import com.taitly.arrays.parser.ArrayParser;
import com.taitly.arrays.parser.impl.IntArrayParser;
import com.taitly.arrays.reader.ArrayFileReader;
import com.taitly.arrays.reader.impl.ArrayFileReaderImpl;
import com.taitly.arrays.service.ArrayMathService;
import com.taitly.arrays.service.ArraySortingService;
import com.taitly.arrays.service.impl.ArrayMathServiceImpl;
import com.taitly.arrays.service.impl.BubbleSortService;
import com.taitly.arrays.service.impl.SelectionSortService;
import com.taitly.arrays.validation.ArrayValidator;
import com.taitly.arrays.validation.impl.IntArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String DATA_FILE_PATH = "data/arrays.txt";

    private final ArrayFileReader reader = new ArrayFileReaderImpl();
    private final ArrayValidator validator = new IntArrayValidator();
    private final ArrayParser parser = new IntArrayParser();
    private final ArrayFactory factory = new IntArrayFactory();
    private final ArrayMathService mathService = new ArrayMathServiceImpl();
    private final ArraySortingService bubbleSortingService = new BubbleSortService();
    private final ArraySortingService selectionSortingService = new SelectionSortService();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Path path = Paths.get(DATA_FILE_PATH);
        List<String> arrayStrings;

        try {
            arrayStrings = reader.read(path);
        } catch (CustomException exception) {
            logger.error("Failed to read file: {}", DATA_FILE_PATH, exception);
            return;
        }

        for (String arrayString : arrayStrings) {
            if (!validator.isValid(arrayString)) {
                logger.warn("Invalid array string, skipped: '{}'", arrayString);
                continue;
            }

            int[] numbers = parser.parse(arrayString);
            IntArrayEntity intArrayEntity = factory.create(numbers);

            logger.info("Processing array: {}", intArrayEntity);

            OptionalInt max = mathService.findMax(intArrayEntity);
            OptionalInt min = mathService.findMin(intArrayEntity);
            OptionalLong sum = mathService.calculateSum(intArrayEntity);
            OptionalDouble average = mathService.calculateAverage(intArrayEntity);

            logger.info("Max: {}", max.isPresent() ? max.getAsInt() : "not available");
            logger.info("Min: {}", min.isPresent() ? min.getAsInt() : "not available");
            logger.info("Sum: {}", sum.isPresent() ? sum.getAsLong() : "not available");
            logger.info("Average: {}", average.isPresent() ? average.getAsDouble() : "not available");

            IntArrayEntity bubbleEntity = factory.create(numbers);
            bubbleSortingService.sort(bubbleEntity);
            logger.info("Bubble sort result: {}", bubbleEntity);

            IntArrayEntity selectionEntity = factory.create(numbers);
            selectionSortingService.sort(selectionEntity);
            logger.info("Selection sort result: {}", selectionEntity);
        }

    }
}
