package com.wordcounter.counter;

import com.wordcounter.counter.reader.Reader;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter implements Counter {

    private HashMap<String, Integer> map;
    private final Reader reader;

    public WordCounter(final Reader reader) {
        this.reader = reader;
    }

    @Override
    public List<String> getPopularWords(int numberOfWords, File file) {
        map = new HashMap<>();

        return process(reader.read(file), numberOfWords);
    }

    @Override
    public List<String> getPopularWords(int numberOfWords, String text) {
        map = new HashMap<>();

        return process(text, numberOfWords);
    }

    private List<String> process(String text , int numberOfWords) {

        String[] textArray = text.replaceAll("( )+", " ").split(" ");

        Arrays.stream(textArray)
                .map(n -> n.replaceAll("[^a-zA-Z]", ""))
                .forEach(this::addWordToMap);

        return getWordsFromMap(numberOfWords);
    }

    private void addWordToMap(String word) {

        map.putIfAbsent(word, 0);
        map.put(word, map.get(word) + 1);
    }

    private List<String> getWordsFromMap(int numberOfWords) {

        return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(numberOfWords)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}