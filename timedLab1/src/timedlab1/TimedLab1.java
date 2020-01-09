/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedlab1;

/**
 *
 * @author Belle
 */
public class TimedLab1 {

    public static void printBoxed(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();

    }

    public static void printStars(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void printNum() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i * j);
            }
            System.out.println();
        }

    }

    public static void approxPI(int n) {
        for (int i = 1; i <= n; i++) {
            double j = (1 / i + 2);
            double pi = (4 * j);
            System.out.println(pi);
        }

        System.out.println();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printBoxed(7);
        printBoxed(5);
        printStars(4);
        printStars(2);
        printStars(5);
        printNum();
        approxPI(3);
        // TODO code application logic here
    }

}
