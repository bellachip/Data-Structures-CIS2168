/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Belle
 */
public class Arraylist<E> {

    //Takes in a list and returns true if all the items in the list are unique else flase 
    public static <T> boolean unique(List<T> list) {
        //ArrayList a = new ArrayList();
        
        Object a, b;
        for (int i = 0; i < list.size() - 1; i++) {
            a = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                b = list.get(j);
                if (a.equals(b)) {
                    return false;
                }
            }
        }
        return true;
    }

       
    
    //takes in a list of integers and an int. returns a new list of integers which conatins all of 
    //the numbers from the input list which are multiples of the given int
    public static List allMultiples(List<Integer> list, int a) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % a == 0) {
                b.add(list.get(i));

            }

        }
        return b;
    }

    //takes in a list<String> and an int length. 
    //The method returns a new List<String> which contains all the Strings from the original list that are legnth characters long. 
    public static ArrayList<String> allStringsOfSize(List<String> list, int length) {
        ArrayList<String> str = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == length) {
                str.add(list.get(i));
            }
        }
        return str;
    }

    //takes in two list objects which contain the same types. 
    //Returns true if the Lists are permutations of each other and false if not. 
    public static <A extends Comparable<A>> boolean isPermutation(List<A> lst1, List<A> lst2) {

        Collections.sort(lst1);
        Collections.sort(lst2);
        for (int i = 0; i < lst1.size(); i++) {
            if (lst1.get(i) != lst2.get(i)) {
                return false;
            }
        }
        return true;
    }

    //s.replaceAll("[^a-zA-Z0-9]", " ");
    //ArrayList<String> a = new ArrayList<>(Arrays.asList(items));
    //takes in a String converts in into a list of words
    //asumes that each word in the input string is separated by whitespace
    public static List<String> stringToListOfWords(String s) {
        List<String> stringList = new ArrayList<String>();
        String[] items = s.split("\\s+");

        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(",")){
                continue;
            }
            String word = items[i].replaceAll("[^a-zA-Z0-9]", "");
            stringList.add(word);      
        }
        return stringList;
    }


    public static <E> void RemoveAllInstances(List<E> obj, Object item) {
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).equals(item)) {
                obj.remove(i);
                i = -1;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(12, 16, 15, 15, 17, 3);
        List<Integer> num1 = Arrays.asList(17, 16, 15, 15, 12, 3);
        System.out.println(num);
        System.out.println(unique(num));
        System.out.println(allMultiples(num, 3));
         List<String> str = Arrays.asList("Hello", "Hi", "Howdy");
        System.out.println(allStringsOfSize(str, 2));
        System.out.println(isPermutation(num, num1));
       
        System.out.println(stringToListOfWords("hello world! , my name is bella."));
        List<Integer> q = new ArrayList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(5);
        RemoveAllInstances(q, 3);
        System.out.println(q);
    }
}
