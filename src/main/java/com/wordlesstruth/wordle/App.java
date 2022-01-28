package com.wordlesstruth.wordle;

import java.util.Set;

import com.wordlesstruth.wordle.input.FileHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public final class App {

    private static final String FILENAME = "words.txt";
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App() {
        Set<String> words = FileHandler.getWords(FILENAME);

        if (words.isEmpty()) {
            LOGGER.error("Error getting words, check that your path is correct");
            System.exit(1);
        }

        for (String word : words) {
            LOGGER.info(word);
        }

    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        LOGGER.info("Starting Wordle App");
        new App();
    }
}
