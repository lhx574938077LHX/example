package com.icefox.mianshi;

public class Erfenchazhao {

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
        sort(array);
        for (int i = 0; i < array.length; i++) {
            // System.out.println(array[i]);
        }
        int index = search(array, 6, 0, array.length - 1);
        System.out.println(index);
    }

    public static void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int search(int[] array, int number, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] == number) {
            return mid + 1;
        }
        if (start < end) {
            if (array[mid] > number) {
                return search(array, number, start, mid - 1);
            } else if (array[mid] < number) {
                return search(array, number, mid + 1, end);
            }
        }
        return -1;
    }

}
