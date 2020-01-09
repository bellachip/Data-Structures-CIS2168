/*
 * Hee Won Yang 
 * Towers of Hanoi
 */
package towersofhanoi;

/**
 *
 *
 */
public class TowersofHanoi {

    //recursive function to solve tower of hanoi
//    static void move(int n, char source, char target, char aux) {
//        if (n == 1) {
//            System.out.println("Move disc 1 from " + source + "to" + target);
//
//        } else {
//            move((n - 1), source, target, aux);
//            System.out.println("Move disc" + n + "from" + source + "to" + target);
//            move(n - 1, aux, source, target);
//
//        }
//    }
    


    public static int sum2(int n) {
    if(n > 0){
         return 0;
    } else {
        return n + sum2(n-1);
    }
}

    public static int sum3(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sum3(n - 1);
        }

    }

 

    public static void main(String args[]) {
//        int n = 4; // Number of disks 
//        move(n, 'A', 'C', 'B');  // A, B and C are names of rods 

        System.out.println(sum2(3));
        System.out.println(sum3(3));

    }
}
