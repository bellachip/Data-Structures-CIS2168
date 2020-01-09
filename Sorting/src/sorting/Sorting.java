/*
 * Hee Won Yang; CIS 2168; 
 * Citation: Data Structures book and Geeks for Geeks 
 */
package sorting;

import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Belle
 */
public class Sorting {
    
    public static  int comp1;
    public static int ex1;
    public static int comp2;
    public static int ex2; 
    public static int comp3; 
    public static int ex3;
    
    public static void insertionSort(int[] items) {
        for (int nextPos = 1; nextPos < items.length; nextPos++) {
            int nextVal = items[nextPos];
            int j = nextPos - 1;
            while (j >= 0 && items[j] > nextVal) {
                comp1++;
                items[j + 1] = items[j];
                //comp1++;
                //ex1++;
                j = j - 1;
                ex1++;
            } comp1++;
            items[j + 1] = nextVal;
            ex1++;
        }
    }

    /* This function takes last element as pivot, places the pivot element at
    its correct position in sorted array, and places all smaller
    (smaller than pivot) to left of the pivot and all greater elements to right of pivot*/
    public static int partition(int[] items2, int low, int high) {
      
        int pivot = items2[high];
        int i = (low - 1); //index of smaller element 
        for (int j = low; j < high; j++) {
            // if current element is smaller than or equal to pivot 
            comp2++;
            if (items2[j] <= pivot) {
                i++;

                //sqap arr[i] and arr[j]
                int temp = items2[i];
                items2[i] = items2[j];
                items2[j] = temp;  
                ex2++;
            } 
        }
       
        
        //swap arr[i+1] and arr[high] (or pivot)
        int temp = items2[i + 1];
        items2[i + 1] = items2[high];
        items2[high] = temp;
        ex2++;
        return i + 1;
        
    }

    /* The main function that implements QuickSort() 
    arr[] ---> Array to be sorted 
    low ---> Starting index, 
    high---> Ending index */
    public static void quickSort(int[] items2, int low, int high) {
        if (low < high) {
            int pi = partition(items2, low, high);

            //Recursively sort elements before partition and after partition.
            quickSort(items2, low, pi - 1);
            quickSort(items2, pi + 1, high);
        }

    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) {
           
            // Move current root to end 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            ex3++;

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) {
          
            largest = l;
        }

        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            
            largest = r;
        }

        // If largest is not root 
        if (largest != i) {
            comp3++;
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }

//    static void printArray(int item[]) {
//        int n = item.length;
//        System.out.print("[");
//        for (int i = 0; i < n; i++) {
//            System.out.print(item[i] + ",");
//        }
//        System.out.print("]");
//        System.out.println();
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
                int[] arr = new int[1024];
        for (int i = 0; i<1024; i++) {
            int random = (int) (Math.random() * 1024 +1);
            arr[i] = random;
        }
        
          int[] arr2 = new int[500];
        for (int i = 0; i<500; i++) {
            int random = (int) (Math.random() * 500 +1);
            arr2[i] = random;
        }
        
        
          int[] arr3 = new int[250];
        for (int i = 0; i<250; i++) {
            int random = (int) (Math.random() * 250 +1);
            arr3[i] = random;
        }
        
        
          int[] arr4 = new int[125];
        for (int i = 0; i<125; i++) {
            int random = (int) (Math.random() * 125 +1);
            arr4[i] = random;
        }
        
          int[] arr5 = new int[40];
        for (int i = 0; i<40; i++) {
            int random = (int) (Math.random() * 40 +1);
            arr5[i] = random;
        }
        
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Insertion");
        sb.append(',');
        sb.append(" ");
        sb.append(',');
        sb.append(" ");
        sb.append(',');
        sb.append("Quicksort");
        sb.append(',');
        sb.append(" ");
        sb.append(',');
        sb.append(" ");
        sb.append(',');
        sb.append("HeapSort");
        sb.append(',');
        sb.append(" ");
        sb.append(',');
        sb.append(" ");
        sb.append('\n');
        
        sb.append("Time");
        sb.append(',');
        sb.append("Exchanges");
        sb.append(',');
        sb.append("Comparisons");
        sb.append(',');
        sb.append("Time");
        sb.append(',');
        sb.append("Exchanges");
        sb.append(',');
        sb.append("Comparisons");
        sb.append(',');
        sb.append("Time");
        sb.append(',');
        sb.append("Exchanges");
        sb.append(',');
        sb.append("Comparisons");
        sb.append('\n');

        long starttime = System.nanoTime();
        insertionSort(arr);
        long time = System.nanoTime() - starttime;
        sb.append(time);
        sb.append(',');
        sb.append(ex1);
        sb.append(',');
        sb.append(comp1);
        sb.append(',');

        long starttime2 = System.nanoTime();
        quickSort(arr, 0, 1023);
        long time2 = System.nanoTime() - starttime2;
        sb.append(time2);
        sb.append(',');
        sb.append(ex2);
        sb.append(',');
        sb.append(comp2);
        sb.append(',');
        

        long starttime3 = System.nanoTime();
        heapSort(arr);
        long time3 = System.nanoTime() - starttime3;
        sb.append(time3);
        sb.append(',');
        sb.append(ex3);
        sb.append(',');
        sb.append(comp3);
        sb.append(',');
        sb.append('\n');
        
        
        long starttime4 = System.nanoTime();
        insertionSort(arr2);
        long time4 = System.nanoTime() - starttime4;
        sb.append(time4);
        sb.append(',');
        sb.append(ex1);
        sb.append(',');
        sb.append(comp1);
        sb.append(',');

        long starttime5 = System.nanoTime();
        quickSort(arr2, 0, 499);
        long time5 = System.nanoTime() - starttime5;
        sb.append(time5);
        sb.append(',');
        sb.append(ex2);
        sb.append(',');
        sb.append(comp2);
        sb.append(',');
        

        long starttime6 = System.nanoTime();
        heapSort(arr2);
        long time6 = System.nanoTime() - starttime6;
        sb.append(time6);
        sb.append(',');
        sb.append(ex3);
        sb.append(',');
        sb.append(comp3);
        sb.append(',');
        sb.append('\n');
        
         long starttime7 = System.nanoTime();
        insertionSort(arr3);
        long time7 = System.nanoTime() - starttime7;
        sb.append(time7);
        sb.append(',');
        sb.append(ex1);
        sb.append(',');
        sb.append(comp1);
        sb.append(',');

        long starttime8 = System.nanoTime();
        quickSort(arr3, 0, 249);
        long time8 = System.nanoTime() - starttime8;
        sb.append(time8);
        sb.append(',');
        sb.append(ex2);
        sb.append(',');
        sb.append(comp2);
        sb.append(',');
        

        long starttime9 = System.nanoTime();
        heapSort(arr3);
        long time9 = System.nanoTime() - starttime9;
        sb.append(time9);
        sb.append(',');
        sb.append(ex3);
        sb.append(',');
        sb.append(comp3);
        sb.append(',');
        sb.append('\n');
        
         long starttime10 = System.nanoTime();
        insertionSort(arr4);
        long time10 = System.nanoTime() - starttime10;
        sb.append(time10);
        sb.append(',');
        sb.append(ex1);
        sb.append(',');
        sb.append(comp1);
        sb.append(',');

        long starttime11 = System.nanoTime();
        quickSort(arr4, 0, 124);
        long time11 = System.nanoTime() - starttime11;
        sb.append(time11);
        sb.append(',');
        sb.append(ex2);
        sb.append(',');
        sb.append(comp2);
        sb.append(',');
        

        long starttime12 = System.nanoTime();
        heapSort(arr4);
        long time12 = System.nanoTime() - starttime12;
        sb.append(time12);
        sb.append(',');
        sb.append(ex3);
        sb.append(',');
        sb.append(comp3);
        sb.append(',');
        sb.append('\n');
        
        
      
        
        
        
        
        
        
        
 
        
    
        
      
    
        heapSort(arr2);
     

        
        

        pw.write(sb.toString());
        pw.close();

        // TODO code application logic here
    }

}
