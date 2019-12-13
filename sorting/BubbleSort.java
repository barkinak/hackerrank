package hackerrank.sorting;

public class BubbleSort {

    public static void main(String[] args){
        int[] a = {3, 9, 8, 3, 9, 7, 9, 7, 0};
        bubbleSort(a);
        printArr(a);
        // Result: [0 3 3 7 7 8 9 9 9]
    }

    static int bubbleSort(int arr[]) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }
        return count;
    }

    static void printArr(int[] arr){
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }

}
