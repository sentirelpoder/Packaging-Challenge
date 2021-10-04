package com.mobiquity.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UTF8FileReaderTest {

    static String PATH;

    @BeforeAll
    static void init() {
        PATH = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
    }
    
    @Test
    void testReadLinesExampleInput() {

        String filePath = PATH + "/src/main/test/resources/example_input";
        List<String> output = new ArrayList<>();
        output.add("81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)");
        output.add("8 : (1,15.3,€34)");
        output.add("75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)");
        output.add("56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)");
        try {
            assertEquals(output, UTF8FileReader.readLines(filePath));
        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    void testReadLinesExampleOutput() {
        String filePath = PATH + "/src/main/test/resources/example_output";
        List<String> output = new ArrayList<>();
        output.add("4");
        output.add("-");
        output.add("2,7");
        output.add("8,9");
        try {
            assertEquals(output, UTF8FileReader.readLines(filePath));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testReadLinesIOException() {
        try {
            assertThrows(IOException.class, () -> UTF8FileReader.readLines("/tmp/foo.txt"));
        } catch (Exception e) {
            fail(e);
        }
    }
}
