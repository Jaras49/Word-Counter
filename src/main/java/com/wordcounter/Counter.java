package com.wordcounter;

import java.util.List;

interface Counter {

    void addWord(String word);

    List<String> get3MostPopularWords();
}