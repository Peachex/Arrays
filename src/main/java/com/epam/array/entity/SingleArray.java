package com.epam.array.entity;

public class SingleArray {
    private int[] array;

    public SingleArray(int... numbers) {
        this.array = numbers;
    }

    public int getElement(int index) {
        return this.array[index];
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        int length = this.array.length;
        SingleArray that = (SingleArray) o;
        if (that.array.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (that.array[i] != this.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (this.array == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < this.array.length; i++) {
            result += this.array[i] * i;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i : this.array) {
            sb.append(i).append("  ");
        }
        return sb.toString().trim();
    }
}