package com.wordcounter.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class TextReader implements Reader {

    @Override
    public String read() {

        ClassLoader classLoader = getClass().getClassLoader();
        Path path = Paths.get(new File(classLoader.getResource("test.txt").getFile()).getPath());
        StringJoiner sj = null;
        try (
                BufferedReader reader = new BufferedReader(Files.newBufferedReader(path))) {
            sj = new StringJoiner("\n");
            String line;
            while ((line = reader.readLine()) != null) {
                sj.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sj.toString();
    }
}
