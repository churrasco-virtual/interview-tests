package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.Main.function;
import static org.example.Main.sortArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Integer[] input_1 = {50, 2, 1, 9};
    Integer[] input_2 = {5, 50, 56};
    Integer[] input_3 = {420, 42, 423};

    @Test
    void sortArrayTest() {
        assertEquals(Arrays.asList(9, 50, 2, 1), sortArray(Arrays.asList(input_1)));
        assertEquals(Arrays.asList(56, 5, 50), sortArray(Arrays.asList(input_2)));
        assertEquals(Arrays.asList(42, 423, 420), sortArray(Arrays.asList(input_3)));
    }

    @Test
    void functionTest() {
        assertEquals("95021", function(input_1));
        assertEquals("56550", function(input_2));
        assertEquals("42423420", function(input_3));
    }

}