package hackerrank.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args){
        int[] a = {3, 9, 8, 3, 9, 7, 9, 7, 0};
        insertionSort(a);
        printArr(a);
        // Result: [0 3 3 7 7 8 9 9 9]
    }

    static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArr(int[] arr){
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }

}
