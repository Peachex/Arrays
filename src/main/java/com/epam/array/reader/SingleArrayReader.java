package com.epam.array.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SingleArrayReader {
    public int[] readArrayFromFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }
        String regex = "\\D+";
        String[] numbers = sb.toString().split(regex);
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    public int[] readArrayFromConsole(int size) {
        int[] result = new int[size];
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input numbers: ");
            for (int i = 0; i < result.length; i++) {
                result[i] = scanner.nextInt();
            }
        }
        return result;
    }
}