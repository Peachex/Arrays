package com.epam.array.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.epam.array.entity.SingleArray;

public class SearchServiceTest {
    @Test
    public void findWithBinarySearchTest() {
        int[] numbers = {1, 2, 9, 8, 3, 4, 6, 5};
        SingleArray array = new SingleArray(numbers);
        SearchService searcher = new SearchService();
        int key = 3;
        boolean condition = searcher.findWithBinarySearch(array, key);
        assertTrue(condition);
    }

    @Test
    public void findMaxElementIndexTest() {
        int expected = 2;
        int[] numbers = {1, 2, 9, 8, 3, 4, 6, 5};
        SingleArray array = new SingleArray(numbers);
        SearchService searcher = new SearchService();
        int actual = searcher.findMaxElementIndex(array);
        assertEquals(actual, expected);
    }

    @Test
    public void findMinElementIndexTest() {
        int expected = 3;
        int[] numbers = {1, 2, 9, -8, 3, 4, 6, 5};
        SingleArray array = new SingleArray(numbers);
        SearchService searcher = new SearchService();
        int actual = searcher.findMinElementIndex(array);
        assertEquals(actual, expected);
    }

    @Test
    public void findSimpleNumbersTest() {
        int[] expected = {1, 2, 3, 17, 5};
        int[] numbers = {1, 2, 9, -8, 3, 17, 6, 5};
        SingleArray array = new SingleArray(numbers);
        SearchService searcher = new SearchService();
        int[] actual = searcher.findSimpleNumbers(array);
        assertEquals(actual, expected);
    }

    @Test
    public void findFibonacciNumbersTest() {
        int[] expected = {1, 2, 3, 5};
        int[] numbers = {1, 2, 9, -8, 3, 17, 6, 5};
        SingleArray array = new SingleArray(numbers);
        SearchService searcher = new SearchService();
        int[] actual = searcher.findFibonacciNumbers(array);
        assertEquals(actual, expected);
    }

    @Test
    public void findNumbersWithDifferentDigitsTest() {
        int[] expected = {123, 214, 901, 324};
        int[] numbers = {112, 123, 214, 212, 900, 901, 909, 324};
        SingleArray array = new SingleArray(numbers);
        SearchService searcher = new SearchService();
        int digitsAmount = 3;
        int[] actual = searcher.findNumbersWithDifferentDigits(array, digitsAmount);
        assertEquals(actual, expected);
    }

    @Test
    public void createParameterArrayTest() {
        int[] expected = {6, 10, 100};
        int[][] matrix = {
                {1, 2, 3},
                {10},
                {100},
        };
        int functionNumber = 0;
        SearchService searcher = new SearchService();
        int[] actual = searcher.findParameterArray(matrix, functionNumber);
        assertEquals(actual, expected);
    }
}