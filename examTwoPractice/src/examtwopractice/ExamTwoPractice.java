/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examtwopractice;

import java.util.Arrays;

/**
 *
 * @author Belle
 */
public class ExamTwoPractice {
    
    public int sum2D (int [][] A){
        int sum = 0;
        for (int row =0;row<A.length; row++) {
            for (int col = 0 ; col<A[row].length;col++) {
                sum +=A[row][col];
                
            }
        }
        return sum;
    }
    
    public int[][] bigger2D(int [][]A, int [][]B){
        int sizeA= sum2D(A);
        int sizeB = sum2D(B);
        if (sizeA>sizeB) {
            return A;
        }else {
            return B;
        }
        
    }
    
    public boolean isEverywhere(int[] nums, int val) {
    for (int i=0; i< nums.length; i++) {
        if (nums[i]!=val || nums[i-1]!=val) {
            return false;
            
        }
    }
    return true;
}
    
    public int sumDigits(String str) {
        int sum=0;
        for (int i=0; i< str.length(); i++) {
            char c  = str.charAt(i);
            if (Character.isDigit(0)) {
                sum+=Integer.parseInt(c+"");
                //inside the parenthesis you could put str.substring(i,i+1)
            }
        }
        return sum;
    }
    
    public int [] copyEvents(int[]nums,int count) {
        int [] evens = new int [count];
        int currentIndex=0;
        for (int num: nums) {
            if (num% 2 ==0 && currentIndex <count) {
                evens [currentIndex] = num;
                currentIndex ++;
             }
        } 
        return evens;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[]a={1,2,3,4,5,6};
        
        
    
    }
    
}
