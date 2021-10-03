package com.mobiquity.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class UTF8FileReader {

    /* To hide the public constructor*/
    private UTF8FileReader() {
    }

    public static List<String> readLines(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8).lines().collect(Collectors.toList());
    }
}
