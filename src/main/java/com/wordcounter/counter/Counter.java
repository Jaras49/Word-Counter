package com.wordcounter.counter;

import java.util.List;

interface Counter {

    List<String> getPopularWords(int numberOfWords);
}