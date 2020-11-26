package com.epam.array.main;

import com.epam.array.creator.SingleArrayCreator;
import com.epam.array.entity.JaggedArray;
import com.epam.array.entity.SingleArray;
import com.epam.array.report.ArrayReport;
import com.epam.array.service.SearchService;
import com.epam.array.service.SortService;

public class ProjectMain {
    public static void main(String[] args) {
        SingleArrayCreator creator = new SingleArrayCreator();
        String path = "data\\array.txt";
        SingleArray array = creator.createSingleArray(path);

        ArrayReport reporter = new ArrayReport();
        String message1 = "Array: ";
        reporter.reportArray(array, message1);

        SortService sorter = new SortService();
        sorter.sortArrayWithQuickSort(array);
        String message2 = "Sorted array: ";
        reporter.reportArray(array, message2);

        SearchService searcher = new SearchService();
        int key = 10;
        boolean isInArray = searcher.findWithBinarySearch(array, key);
        reporter.reportBinarySearchResult(array, key, isInArray);

        int maxElement = array.getElement(searcher.findMaxElementIndex(array));
        String message3 = "Max element = ";
        reporter.reportElement(array, maxElement, message3);

        int minElement = array.getElement(searcher.findMinElementIndex(array));
        String message4 = "Min element = ";
        reporter.reportElement(array, minElement, message4);

        SingleArray simpleNumbers = new SingleArray(searcher.findSimpleNumbers(array));
        String message5 = "Simple numbers: ";
        reporter.reportArray(simpleNumbers, message5);

        SingleArray fibonacciNumbers = new SingleArray(searcher.findFibonacciNumbers(array));
        String message6 = "Fibonacci numbers: ";
        reporter.reportArray(fibonacciNumbers, message6);

        int digitsAmount = 3;
        SingleArray numbersWithDifferentDigits = new SingleArray(searcher.findNumbersWithDifferentDigits(array, digitsAmount));
        String message7 = "Numbers with different digits: ";
        reporter.reportArray(numbersWithDifferentDigits, message7);

        int[][] matrix = {
                {1, 2, 3},
                {5, 4, 3, 2, 0},
                {10, 20, 30, 40, 50, 60, 70},
                {90},
        };
        JaggedArray jaggedArray = new JaggedArray(matrix);

        String message8 = "Jagged array: ";
        reporter.reportArray(jaggedArray, message8);

        boolean fromMinToMax = false;

        sorter.sortRowsByRowsSum(jaggedArray, fromMinToMax);
        String message9 = "Sorted by rows sum: ";
        reporter.reportArray(jaggedArray, message9);

        sorter.sortRowsByMaxElement(jaggedArray, fromMinToMax);
        String message10 = "Sorted by rows' max element: ";
        reporter.reportArray(jaggedArray, message10);

        sorter.sortRowsByMinElement(jaggedArray, fromMinToMax);
        String message11 = "Sorted by rows' min element: ";
        reporter.reportArray(jaggedArray, message11);
    }
}