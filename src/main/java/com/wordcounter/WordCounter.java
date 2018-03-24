package com.wordcounter;

import java.util.*;
import java.util.stream.Collectors;

public class WordCounter implements Counter {

    HashMap<String, Integer> map;

    public WordCounter(){
        map = new HashMap<>();
    }

    @Override
    public void addWord(String word){

        map.putIfAbsent(word, 0);
        map.put(word, map.get(word) +1);
    }

    @Override
    public List<String> get3MostPopularWords(){
        int numOfWords = 3;

        List<String> list = map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(numOfWords)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list);
        return list;
    }
}