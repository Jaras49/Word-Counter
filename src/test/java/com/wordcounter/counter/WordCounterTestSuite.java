package com.wordcounter.counter;

import com.wordcounter.counter.reader.Reader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class WordCounterTestSuite {

    private Counter counter;
    private Reader reader;

    private static final String TEST_TEXT = "Jarek Jarek Jarek     Jarek Jarek Jarek\n" +
            "\n" +
            "Jarek Jarek Jarek\n" +
            "\n" +
            "\n" +
            "Jarek Jarek Jarek\n" +
            "\n" +
            "asdasdas   asdasdas  asdasdas   asdasdas  asdasdas\n" +
            "kkkkkkkkk kkkkkkkkk kkkkkkkkk kkkkkkkkk kkkkkkkkk kkkkkkkkk\n" +
            "\n" +
            "\n" +
            "nnnnnn\n" +
            "nnnnnn\n" +
            "nnnnnn\n" +
            "nnnnnn\n" +
            "nnnnnn\n" +
            "\n" +
            "xyz xyz xyz xyz xyz xyz xyz xyz";

    @Before
    public void setUp() throws Exception {
        reader = mock(Reader.class);
        counter = new WordCounter(reader);
    }

    @Test
    public void getPopularWordsTest() {

        //Given
        when(reader.read(new File(""))).thenReturn(TEST_TEXT);
        List<String> expected = new ArrayList<>();
        expected.add("Jarek");
        expected.add("xyz");
        expected.add("kkkkkkkkk");

        //When
        List<String> popularWordsResult = counter.getPopularWords(3, new File(""));
        List<String> popularWordsResult1 = counter.getPopularWords(3, TEST_TEXT);

        //Then
        assertEquals(expected, popularWordsResult);
        assertEquals(expected, popularWordsResult1);
    }
}