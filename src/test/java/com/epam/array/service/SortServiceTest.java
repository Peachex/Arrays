package com.epam.array.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.epam.array.entity.JaggedArray;
import com.epam.array.entity.SingleArray;

public class SortServiceTest {
    private int[] expectedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private SingleArray expected = new SingleArray(expectedNumbers);
    private int[] numbers = {1, 9, 6, 7, 8, 4, 2, 3, 10, 5};
    private SingleArray actual = new SingleArray(numbers);
    private SortService sorter = new SortService();

    @Test
    public void sortArrayWithShellSortTest() {
        sorter.sortArrayWithShellSort(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortArrayWithQuickSort() {
        sorter.sortArrayWithQuickSort(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortArrayWithMergeSortTest() {
        sorter.sortArrayWithMergeSort(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void sortRowsByRowsSumTest() {
        int[][] expected = {
                {100},
                {10, 10},
                {1, 2, 3},
        };

        int[][] matrix = {
                {1, 2, 3},
                {10, 10},
                {100},
        };
        JaggedArray jaggedArray = new JaggedArray(matrix);
        SortService sorter = new SortService();
        boolean fromMinToMax = false;
        sorter.sortRowsByRowsSum(jaggedArray, fromMinToMax);
        int[][] actual = jaggedArray.getMatrix();
        assertEquals(actual, expected);
    }

    @Test
    public void sortRowsByMaxElementTest() {
        int[][] expected = {
                {1, 2, 3},
                {10, 10},
                {100},
        };

        int[][] matrix = {
                {1, 2, 3},
                {10, 10},
                {100},
        };
        JaggedArray jaggedArray = new JaggedArray(matrix);
        SortService sorter = new SortService();
        boolean fromMinToMax = true;
        sorter.sortRowsByMaxElement(jaggedArray, fromMinToMax);
        int[][] actual = jaggedArray.getMatrix();
        assertEquals(actual, expected);
    }

    @Test
    public void sortRowsByMinElementTest() {
        int[][] expected = {
                {100},
                {10, 10},
                {1, 2, 3},
        };

        int[][] matrix = {
                {1, 2, 3},
                {10, 10},
                {100},
        };
        JaggedArray jaggedArray = new JaggedArray(matrix);
        SortService sorter = new SortService();
        boolean fromMinToMax = false;
        sorter.sortRowsByMinElement(jaggedArray, fromMinToMax);
        int[][] actual = jaggedArray.getMatrix();
        assertEquals(actual, expected);
    }
}