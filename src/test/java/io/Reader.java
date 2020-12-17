package io;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Reader {

    private Reader() {
    }

    public static List<Integer> readFile(String fileName) {
        ArrayList<String> arrayStringList = new ArrayList<>();
        try (Scanner s = new Scanner(getFileFromResource(fileName), "UTF-8").useDelimiter("\\s*,\\s*")) {
            while (s.hasNext()) {
                arrayStringList.add(s.next().trim());
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error reading file: " + e);
        }

        List<Integer> arrayIntList = new ArrayList<>();
        arrayStringList.forEach(element -> arrayIntList.add(Integer.parseInt(element)));
        return arrayIntList;
    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = Reader.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
