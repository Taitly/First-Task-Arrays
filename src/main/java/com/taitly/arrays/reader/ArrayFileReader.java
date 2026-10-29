package com.taitly.arrays.reader;

import com.taitly.arrays.exception.CustomException;

import java.nio.file.Path;
import java.util.List;

public interface ArrayFileReader {
    List<String> read(Path path) throws CustomException;
}
