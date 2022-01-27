package com.wordlesstruth.wordle.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);

    public FileHandler() {
        // intentionally blank for now
    }

    public boolean openFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(LOGGER::info);
        } catch (IOException ioe) {
            LOGGER.error("Caught an error attempting to open the file", ioe);
            return false;
        }

        return true;
    }
}
