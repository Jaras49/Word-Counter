package com.wordcounter.counter;

import java.io.File;
import java.util.List;

interface Counter {

    List<String> getPopularWords(int numberOfWords, File file);
    List<String> getPopularWords(int numberOfWords, String text);
}