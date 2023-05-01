import dictionary.Dictionary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class DictionaryTest {
    private static final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    void addToDictionaryShouldAddToDictionary() {
        Dictionary dictionary = new Dictionary();
        dictionary.initialize();

        dictionary.handleWordAddition("test");

        Set<String> expectedWords = new HashSet<>();
        expectedWords.add("test");
        Assertions.assertEquals(expectedWords, dictionary.findWordsStartingWith("t"));
    }

    @Test
    void invalidInputShouldRejectInsertingValue() {
        Dictionary dictionary = new Dictionary();
        dictionary.initialize();

        dictionary.handleWordAddition("123");

        String expectedOutput = "The word \"123\" contains invalid characters and cannot be added to the dictionary.";
        Assertions.assertEquals(expectedOutput, getOutput());
    }

    @Test
    void shouldSearchMultipleValues() {
        Dictionary dictionary = new Dictionary();
        dictionary.initialize();

        Set<String> words = dictionary.findWordsStartingWith("ja");

        Set<String> expectedWords = new HashSet<>();
        expectedWords.add("java");
        expectedWords.add("javascript");
        Assertions.assertEquals(expectedWords, words);
    }

    @Test
    void shouldReturnEmptySetIfNoMatches() {
        Dictionary dictionary = new Dictionary();
        dictionary.initialize();

        Set<String> words = dictionary.findWordsStartingWith("xy");

        Assertions.assertTrue(words.isEmpty());
    }

    private String getOutput() {
        return testOut.toString().trim();
    }
}