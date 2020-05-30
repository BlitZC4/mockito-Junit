package com.gazoul.unittesting.mockitoJunit.spike;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void Learning(){
        List<Integer> numbers = Arrays.asList(25, 40, 50);
        assertThat(numbers).hasSize(3).contains(25,40).allMatch(x ->x>10)
                .allMatch(x -> x<100);
        assertThat("").isEmpty();
        assertThat("abcde").contains("ab").startsWith("ab").endsWith("cde");
    }
}
