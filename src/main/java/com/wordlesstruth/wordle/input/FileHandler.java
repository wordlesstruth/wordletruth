package com.wordlesstruth.wordle.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);

    private static final Integer WORDLE_WORD_SIZE = 5;

    private FileHandler() {
    }

    public static Set<String> getWords(String fileName) {
        Set<String> words = new HashSet<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(words::add);
        } catch (IOException ioe) {
            LOGGER.error("Caught an error attempting to open the file", ioe);
        }

        return sanitizeWordsSet(words);
    }

    private static Set<String> sanitizeWordsSet(Set<String> lines) {
        Set<String> words = new HashSet<>();
        for (String line : lines) {

            // First, split the line by whitespace
            for (String entry : line.split("\\s+")) {
                // If the entry is only alphabetical characters and the right size, we have a
                // good hit.
                // This could be made slightly better as it currently assumes a halfway decent
                // attempt at providing words.
                if (entry.length() == WORDLE_WORD_SIZE && entry.matches("[a-zA-Z]+")) {
                    words.add(entry);
                    break;
                }
            }

        }

        return words;
    }
}
