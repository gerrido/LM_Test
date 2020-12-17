package org.example;

import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

import static io.Reader.fileRead;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest 
{
    @Test
    public void whenRandomIntInArrayReturnsTrue()
    {
        var arrayInt = fileRead("testNumbers.txt");

        var max = arrayInt.stream().max(Integer::compare).get();
        var min = arrayInt.stream().min(Integer::compare).get();

        int randomNumber = ThreadLocalRandom.current().nextInt(min, max);
        assertThat( arrayInt ).contains(randomNumber);
    }
}
