/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blamepopegregory;

import java.util.Scanner;

/**
 *
 * @author Belle
 */
public class BlamePopeGregory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String format = "MM/DD/YYYY";

        System.out.println("Input date in the format MM/DD/YYYY: ");
        String a = input.nextLine();
        String aa = a.substring(0, 10);

        String dd = a.substring(3, 5);
        int date = Integer.parseInt(dd);

        String mm = a.substring(0, 2);
        int month = Integer.parseInt(mm);

        if (0 < month && month <= 12) {
            System.out.println("months are valid");
        } else {
            System.out.println("months are not valid");
        }
        if (a.length() != format.length()) {
            System.out.println("your date is not formatted correctly.");
        }
        if (date == 31 && month == 04 || month == 06 || month == 11) {
            System.out.println("September, April, June, and November should have 30 days");
        }
        if (date == 30 && month == 01 || month == 03 || month == 05 || month == 07 || month == 12) {
            System.out.println("All other months but Febuary should have 31 days");
        }
        if (date == 31 || month == 02) {
            System.out.println("Febuary should have 28 days, except on a leap year, where it has 29");
        }

        String yy = a.substring(6, 10);
        int year = Integer.parseInt(yy);
        System.out.println(yy); //prints yy

        if (year % 4 != 0) {
            System.out.println("A year is a normal year.");
        } else if (year % 4 == 0 || year % 400 == 0) {
            System.out.println("A year is a leap year");
        } else if (year % 100 == 0) {
            System.out.println("A year is not a leap year ");
        }

        // TODO code application logic here
    }

}
