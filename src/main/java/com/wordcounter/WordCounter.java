package com.wordcounter;

import java.util.*;

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

        ArrayList<Map.Entry<String, Integer>> entriesToSort = new ArrayList<>(map.entrySet());
        ArrayList<String> listOfMostPopularWords = new ArrayList<>();

        Collections.sort(entriesToSort, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i = 0; i <numOfWords; i++){
            listOfMostPopularWords.add(entriesToSort.get(entriesToSort.size() -1 - i ).getKey());
        }
        return listOfMostPopularWords;
    }
}