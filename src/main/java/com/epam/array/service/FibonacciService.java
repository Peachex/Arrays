package com.epam.array.service;

public class FibonacciService {
    public int[] findFibonacciNumbersArray(int maxElement) {
        int current = 1;
        int previous = 0;
        int count = 2;
        while (current < maxElement) {
            current += previous;
            previous = current - previous;
            count++;
        }
        int[] result = new int[count];
        current = 1;
        previous = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = previous;
            current += previous;
            previous = current - previous;
        }
        return result;
    }

    public boolean checkNumberForFibonacci(int number, int[] fibonacciNumbers) {
        int count = 0;
        while (count < fibonacciNumbers.length && number >= fibonacciNumbers[count]) {
            if (number == fibonacciNumbers[count++]) {
                return true;
            }
        }
        return false;
    }
}