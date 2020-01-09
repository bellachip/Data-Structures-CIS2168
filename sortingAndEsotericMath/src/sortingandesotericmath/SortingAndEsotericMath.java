/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingandesotericmath;

import java.util.Arrays;
import java.util.*;

/**
 *
 * @author Belle
 */
//selecting the smallest value in the array and swapping with the value at index 0.
//Then the algorithm moves onto finding the smallest value starting from index 1 
//and swapping it with the value at index 1. 
//Then the algorithm moves onto finding the smallest value starting from index 2 
//and swapping it with index 2. This continues until all the values are sorted.
public class SortingAndEsotericMath {

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
    
    
    //The bubble sort algorithm examines all adjacent pairs of elements in the array 
    //from the beginning to the end and swaps any two elements that are out of order. 
    //Each interchange makes the array more sorted than it was, until it is entirely sorted. 
    //The algorithm in pseudocode follows:
    public static int[] bubbleSort(int[] a) {

        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < (a.length - i); j++) {

                if (a[j - 1] > a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
    
    //for (index = 1; index < a.length; index++)
    //insert value at index into the the appropriate place
    //in the sorted subsection of the array,
    //increasing the length of the sorted subsection by 1
    public static int[] insertionSort(int[] input) {

        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
        return input;
    }

    public static int collatz(int n) {

        if (n % 2 == 0) {
            return n / 2;
        }
        return n * 3 + 1;
    }

    public static long numLongestCollatzSequence(int max) {
        HashMap<Long, Long> lengths = new HashMap<>();
        lengths.put(1L, 1L);
        long best = 1L;
        for (long i = 2L; i <= max; ++i) {
            ArrayList<Long> path = new ArrayList<>();
            long curr = i;
            while (!lengths.containsKey(curr)) {
                path.add(curr);
                if (curr % 2L == 0L) {
                    curr = curr / 2L;
                } else {
                    curr = 3L * curr + 1L;
                }
            }
            if (curr != i) {
                long l = lengths.get(curr);
                for (int j = path.size() - 1; j >= 0; --j) {
                    lengths.put(path.get(j), ++l);
                }
            }
            if (lengths.get(i) > lengths.get(best)) {
                best = i;
            }
        }
        return best;
    }

    /*
        int result = n;
        if (result <= 1) {
            return 1;
        }
        if (result % 2 == 0) {
            return 1 + collatz(result / 2);
        }
        return 1 + collatz(3 * result + 1);
    }
     */

 /*

                int n = a.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (a[j] > a[j + 1]) {
                            // swap temp and arr[i]
                            int temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                        }
                    }
                }
                return a;
            }
     */
    /**
     * @param args the command line arguments
     */
    
     public static int chainCounter(long a) {
        int count = 0;
        while (a != 1) {
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = 3 * a + 1;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {

        int[] a = {10, 34, 2, 56, 7, 67, 88, 42};
        int[] b = selectionSort(a);
        System.out.print(Arrays.toString(selectionSort(a)));

        System.out.println();

        int[] c = {64, 34, 25, 12, 22, 11, 90};
        int[] d = bubbleSort(c);
        System.out.println(Arrays.toString(bubbleSort(c)));

        int[] e = {13, 14, 17, 1, 5, 3, 9};
        System.out.println(Arrays.toString(insertionSort(e)));

        //System.out.println(collatz(10));
        int max = 10;
        System.out.println(numLongestCollatzSequence(max));
    
  

        int chainLength = 0;
        int maxChain = 0;
        int MaxNum = 0;
        for (int i = 2; i < 1000000; i++) {
            chainLength = chainCounter(i);
            if (chainLength > maxChain) {
                maxChain = chainLength;
                MaxNum = i;
            }
        }
    }

   
}

