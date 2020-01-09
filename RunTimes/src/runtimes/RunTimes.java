/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Belle
 */
public class RunTimes {

    public static int howBig(List<?> list) {
        return list.size();
    }

    public static <E> boolean in(List<E> list, E item) {
        Comparable c;
        //for each thing in the list if item equals thing then true 
        for (E thing : list) {
            for (int i = 0; i < 1000; i++) { //slowing this down. 
                System.out.print("");
            }
            if (item.equals(thing)) {
                return true;
            }
        }
        return false;
    }
    //buble sort analysis

    public static <E extends Comparable<E>> void bubblesort(List<E> list) {

        //(n-1)*)(n-1) = n^2 
        for (int runs = 0; runs < list.size(); runs++) {
            for (int i = 0; i < list.size() - 1; i++) {
                E left = list.get(i);
                E right = list.get(i + 1);
                if (left.compareTo(right) > 0) {
                    list.set(i, right);
                    list.set(i + 1, left);
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer x = 5;
        Integer y = 1;

        String n="y";
       

        Scanner input = new Scanner(System.in);
        System.out.println("Input an integer");

        while (n.equals("y") || n.equals("Y")) {
            System.out.println("input string");
             n =input.nextLine();
        }

        System.out.println("Out of loop");
    }
}



//System.out.println(x.compareTo(y));
//System.out.println("bagel".compareTo("Batman"));
/*
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(+rand.nextInt());
        }

        long start = System.currentTimeMillis();
        //best case
        //average case-- check n/2 items. linear relationship- size and time 10-20
        //worst case -- search the item is not in there. check an item if they exist , worst case the item is not there.  
        in(list, -13);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // TODO code application logic here*/
