package com.taitly.arrays.reader.impl;


import com.taitly.arrays.exception.CustomException;
import com.taitly.arrays.reader.ArrayFileReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayFileReaderImpl implements ArrayFileReader {
    @Override
    public List<String> read(Path path) throws CustomException {
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new CustomException(String.format("Failed to read file: %s", path), exception);
        }
    }
}
