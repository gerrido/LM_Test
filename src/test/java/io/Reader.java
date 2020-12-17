package io;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static List<Integer> fileRead(String fileName) {
        ArrayList<String> arrayListString = new ArrayList<>();
        try (Scanner s = new Scanner(getFileFromResource(fileName)).useDelimiter("\\s*,\\s*")) {
            while (s.hasNext()) {
                arrayListString.add(s.next().trim());
            }
        }
        catch (IOException | URISyntaxException e) {
            System.out.println("Error reading file: " + e);
        }

        List<Integer> arrayInt = new ArrayList<>();
        arrayListString.forEach(element -> arrayInt.add(Integer.parseInt(element)));
        return arrayInt;
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
