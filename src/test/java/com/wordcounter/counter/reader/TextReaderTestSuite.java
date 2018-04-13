package com.wordcounter.counter.reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextReaderTestSuite {

    @Test
    public void readTest() {

        //Given
        Reader reader = new TextReader();
        String expected = "Jarek Jarek Jarek Jarek               Jarek\n" +
                "sadasdas sadasdas sadasdas sadasdas\n" +
                "ggggggh ggggggh ggggggh ggggggh\n" +
                "uuuuuuuuuuu uuuuuuuuuuu uuuuuuuuuuu uuuuuuuuuuu";
        //When
        String readActual = reader.read();

        //Then
        assertEquals(expected, readActual);
    }
}