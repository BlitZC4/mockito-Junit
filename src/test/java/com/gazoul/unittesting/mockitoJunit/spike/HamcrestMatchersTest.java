package com.gazoul.unittesting.mockitoJunit.spike;

import org.junit.Test;
import org.mockito.internal.matchers.StartsWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void Learning(){

        List<Integer> numbers = Arrays.asList(12,15,19);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12,15));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));
        assertThat("abc",containsString("bc"));
        assertThat("abc", startsWith("ab"));
        assertThat("abc",endsWith("c"));

    }
}
