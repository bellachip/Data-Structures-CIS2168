/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedlab1arraylist;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Belle
 */
public class TimedLab1ArrayList {

    public static int numberOfVowels(List<String> words) {

        String str;
        int vowels = 0;
        if (words.size() == 0) {
            return vowels;
        } else {
            for (int count = 0; count < words.size(); count++) {
                str = words.get(count);

                for (int j = 0; j < str.length(); j++) {
                    switch (str.charAt(j)) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            vowels++;
                    }
                }
            }
        }
        return vowels;
    }

    public static <T> List <T> Interweave(List<T> listA, List<T> listB) {
      

        List<T> combined = new ArrayList<T>();
        int a = 0;
        int b = 0;

        while (a < listA.size() || b < listB.size()) {
            if (a < listA.size()) {
                combined.add(listA.get(a++));
            }
            if (b < listB.size()) {
                combined.add(listB.get(b++));
            }

        }

        return combined;
    }

    public static int getIndexOfSmallest(List<Integer> list, int index) {
        
        int min=list.get(index);
        int a=0;
        for (int i = index+1; i < list.size(); i++) {
            int num = list.get(i);
            if (num < min) {
                min=num;
              
            }
        }
 
           return min;
    }

   
    
    public static void selectionSort(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(pos))
                    pos = j;
            }
            int min = list.get(pos);
            list.set(pos, list.get(i));
            list.set(i, min);
        }
        System.out.println("Sorted list: " + list);
 
}


        /**
         * @param args the command line arguments
         */
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hi");

        System.out.println(numberOfVowels(list)); //prints the number of vowels 

        List<String> a = Arrays.asList("A", "B", "C");
        List<String> b = Arrays.asList("D", "E", "F", "T");

        List<Integer> t = new ArrayList<Integer>();
        t.add(7);
        t.add(3);
        t.add(5);
        t.add(7);
        t.add(9);
        t.add(11);

        List<Integer> g = new ArrayList<Integer>();
        g.add(9);
        g.add(4);
        g.add(6);
        g.add(8);
        g.add(1);
        g.add(12);
        
        List<Integer> e = Arrays.asList(1,5,2,7,4,78,12);

        System.out.println(Interweave(a, b));//prints interweave
        
        System.out.println(getIndexOfSmallest(e,3)); //prints the smallest index
        selectionSort(e);
      

        // TODO code application logic here
    }

  
}
