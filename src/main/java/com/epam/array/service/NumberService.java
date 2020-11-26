package com.epam.array.service;

import java.util.Random;

public class NumberService {
    public int[] findDigitsArray(int number) {
        int size = (int) Math.log10(number) + 1;
        int length = (int) (Math.pow(10, (int) Math.log10(number)));
        int[] digits = new int[size];
        int count = 0;
        while (number != 0) {
            digits[count++] = number / length;
            number %= length;
            length /= 10;
        }
        return digits;
    }

    public int[] findRandomNumbersArray(int size, int maxValue) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(maxValue) + 1;
        }
        return result;
    }

    public boolean checkNumberForSimplicity(int number) {
        if (number == 0) {
            return false;
        }
        number = Math.abs(number);
        int i = 2;
        while (i <= number / 2) {
            if (number % i++ == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNumberForDifferentDigits(int[] digits) {
        int i = 0;
        while (i < digits.length - 1) {
            int j = i + 1;
            while (j < digits.length) {
                if (digits[i] == digits[j++]) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}