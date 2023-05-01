package dictionary;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static utils.DictionaryUtils.printSeparatedWords;
import static utils.DictionaryUtils.validateWord;

@Slf4j
public class Dictionary {
    private final Scanner scanner;
    private final Map<Character, Set<String>> dictionary;

    private static final String EXIT = "EXIT";
    private static final String ADD_TO_THE_DICTIONARY_OR_ENTER_EXIT_TO_EXIT = "Enter a word to add to the dictionary (or enter 'EXIT' to exit):";
    private static final String SEARCH_IN_THE_DICTIONARY_OR_ENTER_EXIT_TO_EXIT = "Enter a word to search in the dictionary (or enter 'EXIT' to exit):";
    private static final String INITIAL_DICTIONARY_FILE = "InitialDictionary.txt";


    public Dictionary() {
        dictionary = new HashMap<>();
        scanner = new Scanner(System.in);
        Runtime.getRuntime().addShutdownHook(new Thread(scanner::close));
    }

    public void initialize() {
        try {
            File file = new File(INITIAL_DICTIONARY_FILE);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim();
                handleWordAddition(word);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            log.error("Failed to read initial dictionary file: {}", e.getMessage());
        }
    }

    public void addToDictionary() {
        while (true) {
            log.info(ADD_TO_THE_DICTIONARY_OR_ENTER_EXIT_TO_EXIT);
            String input = scanner.nextLine();
            if (input.equals(EXIT)) {
                break;
            }
            handleWordAddition(input);
        }
    }

    public void handleWordAddition(String word) {
        if (validateWord(word))
            dictionary.computeIfAbsent(word.toLowerCase().charAt(0), k -> new HashSet<>()).add(word.toLowerCase());
    }

    public void searchWords() {
        while (true) {
            log.info(SEARCH_IN_THE_DICTIONARY_OR_ENTER_EXIT_TO_EXIT);
            String input = scanner.nextLine();
            if (input.equals(EXIT)) {
                break;
            }
            printSeparatedWords(findWordsStartingWith(input));
        }
    }

    public Set<String> findWordsStartingWith(String prefix) {
        String lowerPrefix = prefix.toLowerCase();
        if (checkIfPrefixIsNotEmptyAndDictionaryContainsIt(lowerPrefix)) {
            return new HashSet<>();
        }

        Set<String> words = dictionary.get(lowerPrefix.charAt(0));

        return words.parallelStream()
                .filter(word -> word.startsWith(lowerPrefix))
                .collect(Collectors.toSet());
    }

    private boolean checkIfPrefixIsNotEmptyAndDictionaryContainsIt(String prefix) {
        return prefix.isEmpty() || !dictionary.containsKey(prefix.charAt(0));
    }
}
