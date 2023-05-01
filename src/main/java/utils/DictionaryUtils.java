package utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.StringJoiner;

@Getter
@Slf4j
public final class DictionaryUtils {
    public static boolean validateWord(String word) {
        if (!word.matches("[a-zA-Z]+")) {
            log.error("The word \"" + word + "\" contains invalid characters and cannot be added to the dictionary.");
            return false;
        }
        return true;
    }

    public static void printSeparatedWords(Set<String> words) {
        StringJoiner joiner = new StringJoiner(", ");
        words.forEach(joiner::add);

        log.info(joiner.toString());
    }
}