package com.epam.array.entity;

public class JaggedArray {
    private int[][] matrix;

    public JaggedArray(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getElement(int index1, int index2) {
        return this.matrix[index1][index2];
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        int length = this.matrix.length;
        JaggedArray that = (JaggedArray) o;
        if (that.matrix.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (that.matrix[i].length != this.matrix[i].length) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (that.matrix[i][j] != this.matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (this.matrix == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                result += this.matrix[i][j] * i * j;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int[] i : this.matrix) {
            sb.append("{");
            for (int j : i) {
                sb.append(j).append("  ");
            }
            sb.append("}  ");
        }
        return sb.toString();
    }
}