package com.wordcounter.counter;

import com.wordcounter.counter.reader.Reader;

import java.util.*;
import java.util.stream.Collectors;

public class WordCounter implements Counter {

    private final HashMap<String, Integer> map;
    private final Reader reader;

    public WordCounter(final Reader reader) {
        map = new HashMap<>();
        this.reader = reader;
    }

    @Override
    public List<String> getPopularWords(int numberOfWords) {

        return process(reader.read());
    }

    private List<String> process(String text) {

        String[] textArray = text.replaceAll("( )+", " ").split(" ");

        Arrays.stream(textArray)
                .map(n -> n.replaceAll("[^a-zA-Z]", ""))
                .forEach(this::addWordToMap);

        return getWordsFromMap();
    }

    private void addWordToMap(String word) {

        map.putIfAbsent(word, 0);
        map.put(word, map.get(word) + 1);
    }

    private List<String> getWordsFromMap() {
        int numOfWords = 3;

        return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(numOfWords)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}