package com.epam.array.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class NumberServiceTest {
    @Test
    public void findDigitsArrayTest() {
        int[] expected = {1, 2, 3, 4, 5, 1};
        NumberService service = new NumberService();
        int number = 123451;
        int[] actual = service.findDigitsArray(number);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberForSimplicityTest() {
        NumberService service = new NumberService();
        int number = 17;
        boolean condition = service.checkNumberForSimplicity(number);
        assertTrue(condition);
    }

    @Test
    public void checkNumberForDifferentDigitsTest() {
        NumberService service = new NumberService();
        int number = 12345;
        int[] digits = service.findDigitsArray(number);
        boolean condition = service.checkNumberForDifferentDigits(digits);
        assertTrue(condition);
    }
}