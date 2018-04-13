package com.wordcounter.counter.reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextReaderTestSuite {

    @Test
    public void readTest() {

        //Given
        Reader reader = new TextReader();
        String expected = "Jarek Jarek Jarek     Jarek Jarek Jarek\n" +
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
        //When
        String readActual = reader.read();

        //Then
        assertEquals(expected, readActual);
    }
}