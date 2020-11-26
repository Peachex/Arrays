package com.epam.array.service;

import com.epam.array.entity.JaggedArray;
import com.epam.array.entity.SingleArray;

public class SortService {
    public void sortArrayWithShellSort(SingleArray array) {
        int[] result = array.getArray();
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] > result[i + 1]) {
                swap(result, i, i + 1);
                if (i > 0) {
                    i -= 2;
                }
            }
        }
    }

    public void sortArrayWithQuickSort(SingleArray array) {
        int leftBorder = 0;
        int rightBorder = array.getArray().length - 1;
        quickSort(array.getArray(), leftBorder, rightBorder);
    }

    public void sortArrayWithMergeSort(SingleArray array) {
        mergeSort(array.getArray());
    }

    public void sortRowsByRowsSum(JaggedArray jaggedArray, boolean fromMinToMax) {
        int[][] result = jaggedArray.getMatrix();
        int functionNumber = 0;
        SearchService searcher = new SearchService();
        int[] rowsSumArray = searcher.findParameterArray(result, functionNumber);
        sortRowsByParameter(result, rowsSumArray, fromMinToMax);
    }

    public void sortRowsByMaxElement(JaggedArray jaggedArray, boolean fromMinToMax) {
        SearchService searcher = new SearchService();
        int[][] result = jaggedArray.getMatrix();
        int functionNumber = 1;
        int[] maxElementsArray = searcher.findParameterArray(result, functionNumber);
        sortRowsByParameter(result, maxElementsArray, fromMinToMax);
    }

    public void sortRowsByMinElement(JaggedArray jaggedArray, boolean fromMinToMax) {
        SearchService searcher = new SearchService();
        int[][] result = jaggedArray.getMatrix();
        int functionNumber = 2;
        int[] minElementsArray = searcher.findParameterArray(result, functionNumber);
        sortRowsByParameter(result, minElementsArray, fromMinToMax);
    }

    private void quickSort(int[] array, int leftBorder, int rightBorder) {
        int left = leftBorder;
        int right = rightBorder;
        int pivot = array[(left + right) / 2];
        do {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        } while (left <= right);
        if (left < rightBorder) {
            quickSort(array, left, rightBorder);
        }
        if (right > leftBorder) {
            quickSort(array, leftBorder, right);
        }
    }

    private void mergeSort(int[] array) {
        int[] result = array;
        if (result.length < 2) {
            return;
        }
        int[] leftPart = new int[result.length / 2];
        int[] rightPart = new int[result.length - leftPart.length];
        for (int i = 0; i < leftPart.length; i++) {
            leftPart[i] = result[i];
        }
        for (int i = leftPart.length; i < result.length; i++) {
            rightPart[i - leftPart.length] = result[i];
        }
        mergeSort(leftPart);
        mergeSort(rightPart);
        mergeArray(result, leftPart, rightPart);
    }

    private void mergeArray(int[] array, int[] leftPart, int[] rightPart) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftPart.length && j < rightPart.length) {
            array[k++] = leftPart[i] <= rightPart[j] ? leftPart[i++] : rightPart[j++];
        }
        while (i < leftPart.length) {
            array[k++] = leftPart[i++];
        }
        while (j < rightPart.length) {
            array[k++] = rightPart[j++];
        }
    }

    private void swap(int[] array, int index, int anotherIndex) {
        int temp = array[index];
        array[index] = array[anotherIndex];
        array[anotherIndex] = temp;
    }

    private void sortRowsByParameter(int[][] result, int[] parameterArray, boolean fromMinToMax) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < parameterArray.length - 1; i++) {
                if (fromMinToMax) {
                    if (parameterArray[i] > parameterArray[i + 1]) {
                        swapElements(parameterArray, i);
                        swapRows(result, i);
                        flag = true;
                    }
                } else {
                    if (parameterArray[i] < parameterArray[i + 1]) {
                        swapRows(result, i);
                        swapElements(parameterArray, i);
                        flag = true;
                    }
                }
            }
        }
    }

    private void swapRows(int[][] matrix, int index) {
        int[] temp = matrix[index];
        matrix[index] = matrix[index + 1];
        matrix[index + 1] = temp;
    }

    private void swapElements(int[] array, int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }
}