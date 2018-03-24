package com.wordcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordCounterTestSuite {

    Counter wordCounter;

    @Before
    public void setUp() throws Exception {

        wordCounter = new WordCounter();
    }

    @Test
    public void testGetMostPopularWords(){

        //Given
        wordCounter.addWord("aaa");
        wordCounter.addWord("bbb");
        wordCounter.addWord("bbb");
        wordCounter.addWord("cccccc");
        wordCounter.addWord("cccccc");
        wordCounter.addWord("cccccc");
        wordCounter.addWord("dd");
        wordCounter.addWord("ee");
        wordCounter.addWord("ee");
        wordCounter.addWord("eeee");
        wordCounter.addWord("fff");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("cccccc");
        expectedResult.add("bbb");
        expectedResult.add("ee");

        //When
        List<String> result = wordCounter.get3MostPopularWords();

        //Then
        assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}