/*
 * Hee Won Yang CIS 1068 
 * Assign 6
 */
package cryptanalysis;

import java.util.Scanner;

/**
 *
 * @author Belle
 */
public class Cryptanalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = ":mmZ\\dxZmx]Zpgy";

        System.out.println("Your secret message is: :mmZ\\dxZmx]Zpgy");
        

        System.out.println("Your decrypted message is:");
        for (int Key=1; Key<=100;Key++) {
        for (int i = 0; i < name.length(); i++) {
            char character = name.charAt(i);
            int ascii = (int) character;
            int a = ascii+Key;
            char c = (char) a;
            System.out.print(c);
        }
            System.out.println();
        }
    }
}






            //decode the message using all possible keys between 1 and 100
            /*
            if (ascii + Key > 126) {
                int EncryptedChar = ((ascii + Key) - 127) + 32;
                char ascii2 = (char) EncryptedChar;
                System.out.print(ascii2);
                System.out.print("");
            } else {
                int EncryptedChar2 = (ascii + Key);
                char ascii3 = (char) EncryptedChar2;
                System.out.print(ascii3);
                System.out.print("");
            }
        }
        // TODO code application logic here
    }
}
}*/
