package main;

import dictionary.Dictionary;


public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.initialize();
        dictionary.addToDictionary();
        dictionary.searchWords();

    }

}