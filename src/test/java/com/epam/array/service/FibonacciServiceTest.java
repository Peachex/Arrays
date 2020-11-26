package com.epam.array.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class FibonacciServiceTest {
    @Test
    public void findFibonacciNumbersArrayTest() {
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21};
        FibonacciService service = new FibonacciService();
        int maxElement = 21;
        int[] actual = service.findFibonacciNumbersArray(maxElement);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberForFibonacciTest() {
        int number = 21;
        FibonacciService service = new FibonacciService();
        int[] fibonacciNumbers = service.findFibonacciNumbersArray(number);
        boolean condition = service.checkNumberForFibonacci(number, fibonacciNumbers);
        assertTrue(condition);
    }
}