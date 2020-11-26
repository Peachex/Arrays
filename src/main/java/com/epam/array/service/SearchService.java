package com.epam.array.service;

import com.epam.array.entity.SingleArray;

import java.util.Arrays;

public class SearchService {
    public boolean findWithBinarySearch(SingleArray array, int key) {
        SortService sort = new SortService();
        sort.sortArrayWithQuickSort(array);
        int[] resultArray = array.getArray();
        int low = 0;
        int high = resultArray.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int middleValue = resultArray[(low + high) / 2];
            if (middleValue < key) {
                low = middle + 1;
            } else {
                if (middleValue > key) {
                    high = middle - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public int findMaxElementIndex(SingleArray array) {
        int maxElement = array.getElement(0);
        int index = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getElement(i) > maxElement) {
                maxElement = array.getElement(i);
                index = i;
            }
        }
        return index;
    }

    public int[] findParameterArray(int[][] matrix, int functionNumber) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < result.length; i++) {
            switch (functionNumber) {
                case 0: {
                    result[i] = findRowSum(matrix[i]);
                    break;
                }
                case 1: {
                    result[i] = findMaxElement(matrix[i]);
                    break;
                }
                case 2: {
                    result[i] = findMinElement(matrix[i]);
                    break;
                }
                default: {
                    functionNumber = 0;
                }
            }

        }
        return result;
    }

    public int findMinElementIndex(SingleArray array) {
        int minElement = array.getElement(0);
        int index = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getElement(i) < minElement) {
                minElement = array.getElement(i);
                index = i;
            }
        }
        return index;
    }

    public int[] findSimpleNumbers(SingleArray array) {
        NumberService service = new NumberService();
        int[] cloneArray = Arrays.copyOf(array.getArray(), array.getArray().length);
        int count = 0;
        for (int i = 0; i < cloneArray.length; i++) {
            if (service.checkNumberForSimplicity(cloneArray[i])) {
                count++;
            } else {
                cloneArray[i] = 0;
            }
        }
        return fillResultArray(array, cloneArray, count);
    }

    public int[] findFibonacciNumbers(SingleArray array) {
        int[] cloneArray = Arrays.copyOf(array.getArray(), array.getArray().length);
        FibonacciService service = new FibonacciService();
        int[] fibonacciNumbers = service.findFibonacciNumbersArray(findMaxElementIndex(array));
        int count = 0;
        for (int i = 0; i < cloneArray.length; i++) {
            if (service.checkNumberForFibonacci(cloneArray[i], fibonacciNumbers)) {
                count++;
            } else {
                cloneArray[i] = 0;
            }
        }
        return fillResultArray(array, cloneArray, count);
    }

    public int[] findNumbersWithDifferentDigits(SingleArray array, int digitsAmount) {
        int[] cloneArray = Arrays.copyOf(array.getArray(), array.getArray().length);
        int count = 0;
        int minLimit = (int) Math.pow(10, digitsAmount - 1) - 1;
        int maxLimit = (int) Math.pow(10, digitsAmount) - 1;
        NumberService service = new NumberService();
        for (int i = 0; i < cloneArray.length; i++) {
            if (Math.abs(cloneArray[i]) > minLimit && Math.abs(cloneArray[i]) < maxLimit) {
                if (service.checkNumberForDifferentDigits(service.findDigitsArray(cloneArray[i]))) {
                    count++;
                } else {
                    cloneArray[i] = 0;
                }
            } else {
                cloneArray[i] = 0;
            }
        }
        return fillResultArray(array, cloneArray, count);
    }

    private int[] fillResultArray(SingleArray array, int[] cloneArray, int count) {
        int[] resultArray = new int[count];
        count = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (cloneArray[i] != 0) {
                resultArray[count++] = cloneArray[i];
            }
        }
        return resultArray;
    }

    private int findMaxElement(int[] row) {
        int result = row[0];
        for (int i : row) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }

    private int findMinElement(int[] row) {
        int result = row[0];
        for (int i : row) {
            if (i < result) {
                result = i;
            }
        }
        return result;
    }

    private int findRowSum(int[] row) {
        int sum = 0;
        for (int i : row) {
            sum += i;
        }
        return sum;
    }
}