/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysproblems;

import java.io.PrintStream;
import java.util.Arrays;

/**
 *
 * @author Belle
 */
public class ArraysProblems {

    public static int n(int[] nums) {

        int b = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            b += nums[i];
        }
        return b;
    }

    //Given an array of ints length 3, return an array with the elements
    //"rotated left" so {1, 2, 3} yields {2, 3, 1}.
    public static int[] rotateLeft3(int[] nums) {
        int temp = 0;
        // Interchange the first and last element
        temp = nums[0];
        nums[0] = nums[2];
        nums[2] = temp;
        // Interchange the first and middle element		
        temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;

        return nums;

    }

    public static int[] reverse3(int[] nums) {
        int temp = 0;
        for (int i = 0; i <= nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;

    }

//Given an array of ints length 3, figure out which is larger,
//the first or last element in the array, and set all the other elements
//to be that value. Return the changed array.
    public static int[] maxEnd3(int[] nums) {
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] > (nums[nums.length - 1])) {
                for (int j = 0; j < 3; j++) {
                    nums[j] = nums[i];
                }

            } else {
                for (int k = 0; k < 3; k++) {
                    nums[k] = nums[nums.length - 1];
                }
            }
        }
        return nums;
    }

    /*public static int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0], nums[2]);
        nums[0] = max;
        nums[1] = max;
        nums[2] = max;
        return nums;

        // Solution notes: you could write if-logic to figure out
        // which element is the biggest, but here we use Math.max()
        // to solve that part nicely.
    }*/
//Given an array of ints, return the sum of the first 2 elements in the array.
//If the array length is less than 2, just sum up the elements that exist,
//returning 0 if the array is length 0.
    public static int sum2(int[] nums) {

        if (nums.length >= 2) {
            int temp = nums[0] + nums[1];
            return temp;
        } else if (nums.length == 0) {
            return 0;
        } else {
            int a = nums[0];
            return a;
        }
    }

    //Given 2 int arrays, a and b, each length 3, 
    //return a new array length 2 containing their middle elements
    public static int[] middleWay(int[] a, int[] b) {
        int[] c = new int[2];
        int temp = 0;
        c[0] = a[a.length / 2];
        c[1] = b[b.length / 2];
        return c;

    }

    //Start with 2 int arrays, a and b, each length 2. 
    //Consider the sum of the values in each array. 
    //Return the array which has the largest sum. 
    //In event of a tie, return a.
    public static int[] biggerTwo(int[] a, int[] b) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            count += a[i];
        }

        for (int i = 0; i <= b.length - 1; i++) {
            temp += b[i];

        }

        if (count > temp) {
            return a;
        } else if (temp > count) {
            return b;
        } else {
            return a;
        }

    }

//Given an array length 1 or more of ints, return the difference
//between the largest and smallest values in the array.
//Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) 
//methods return the smaller or larger of two valuesc
//public static bigDiff(int[]nums)
    public static int bigDiff(int[] nums) {

        {
            int max = nums[0];
            int min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                } else if (nums[i] < min) {
                    min = nums[i];
                }
            }
            return (max - min);
        }
    }

    private static String[] recurFizzBuzz(String[] result, int index,int start, int end) {
        if (index > result.length) {
            return result;
        }
        if (index % 15 == 0) {
            result[index - 1] = "FizzBuzz";
        } else if (index % 3 == 0) {
            result[index - 1] = "Fizz";
        } else if (index % 5 == 0) {
            result[index - 1] = "Buzz";
        } else {
            result[index - 1] = Integer.toString(index);
        }
        return recurFizzBuzz(result, index + 1, start, end);
    }

    public static String[] fizzBuzz(int start, int end) {
        return recurFizzBuzz(new String[1 + end - start], start, start, end);
    }

    //Return the number of even ints in the given array. 
    //Note: the % "mod" operator computes the remainder, 
    //e.g. 5 % 2 is 1.
    public static int countEvens(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }


/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        System.out.println(n(a));

        int[] b = {1, 3, 5};
        System.out.println(Arrays.toString(rotateLeft3(b)));

        int[] c = {1, 2, 3};
        System.out.println(Arrays.toString(reverse3(c)));

        int[] d = {1, 2, 3};
        System.out.println(Arrays.toString(maxEnd3(d)));

        int[] e = {1, 2, 3};
        System.out.println(sum2(e));

        int[] f = {1, 2, 3};
        int[] g = {4, 5, 6};
        System.out.println(Arrays.toString(middleWay(f, g)));

        int[] h = {1, 3, 5};
        int[] i = {2, 3, 9};
        System.out.println(Arrays.toString(biggerTwo(h, i)));

        
        System.out.println(Arrays.toString(fizzBuzz(1, 6)));
    }
// TODO code application logic here
}
