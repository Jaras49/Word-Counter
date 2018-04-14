package com.wordcounter.counter.reader;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TextReaderTestSuite {

    @Test
    public void readTest() {

        //Given
        Reader reader = new TextReader();
        File file = new File(getClass().getClassLoader().getResource("test.txt").getFile());
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
        String readActual = reader.read(file);

        //Then
        assertEquals(expected, readActual);
    }
}