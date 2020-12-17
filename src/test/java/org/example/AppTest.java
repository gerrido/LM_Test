package org.example;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.Reader.readFile;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void whenRandomIntInArrayReturnsTrue() {
        List<Integer> arrayInt = readFile("testNumbers.txt");

        int max = Collections.max(arrayInt);
        int min = Collections.min(arrayInt);

        int randomNumber = ThreadLocalRandom.current().nextInt(min, max);
        assertThat(arrayInt).contains(randomNumber);
    }
}
