
package stringmethods;

/**
 *
 * @author Belle
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringMethods {

    /**
     * @param url
     * @return
     */
    /* url is the address of a file on the web, e.g., http://www.espn.com
 * If successful, the method returns the contents of the URL as a String.
 * On failure, it returns null */
    public static String getWebContents(String url) {
        BufferedReader br = null;
        String result = null;
        try {
            URL toFetch = new URL(url);
            br = new BufferedReader(new InputStreamReader(toFetch.openStream()));
            StringBuilder ret = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                ret.append(line + '\n');
                line = br.readLine();
            }
            result = ret.toString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            System.err.println("Malformed URL:  " + url);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error reading from URL:  " + url);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Couldn't close connection to url properly:  " + url);
                }
            }
            return result;
        }
    }

    /* Saves the String contents into a file with name filename.
 * If the file did not previously exist, it is created.
 * If the file with the same name existed previously, it is overwritten. */
    public static void saveDoc(String contents, String filename) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File(filename)));
            pw.print(contents);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error writing to file:  " + filename);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u';
    }

    public static String replacement(String a) {
        int length = a.length();

        a = a.replace("very", "wicked");
        a = a.replace("Very", "Wicked");
        a = a.replace("VERY", "WICKED");
        char lastChar = a.charAt(length - 1);
        String subE = " ";
        char ch;

        if (length > 2) {
            subE = a.substring(length - 3, length - 1);
        }

        if (subE.equals("ee") || subE.equals("i")) {
            if (lastChar == 'r') {
                a = a.replace("r", "yah");
            }

        }
        if (subE.equals("EE") || subE.equals("I")) {
            if (lastChar == 'R') {
                a = a.replace("R", "YAH");

            }
        }

        //replace "r" with "wah"
        if (subE.equals("oo")) {

            if (lastChar == 'r') {
                a = a.replace("r", "wah");
            }
        }
        if (subE.equals("OO")) {

            if (lastChar == 'R') {
                a = a.replace("R", "WAH");
            }
        }

        //replaces "r" with "h"
        for (int i = 1; i <= length - 1; i++) {
            char c = a.charAt(i);
            char c2 = a.charAt(i - 1);
            if (c == 'r' && isVowel(c2)) {
                a = a.replace("r", "h");
            }
        }
        for (int i = 1; i <= length - 1; i++) {
            char c = a.charAt(i);
            char c2 = a.charAt(i - 1);
            if (c == 'R' && isVowel(c2)) {
                a = a.replace("R", "H");
            }
        }

        // adds "r" if the last character is "a"
        if (lastChar == 'a' && length > 1) {
            a = a + "r";
        } else if (lastChar == 'A' && length > 1) {
            a = a + "R";
        }
        return a;
    }

    public static String lining(String last) {
        String result = " ";
        for (int x = 0; x <= 10; x++) {
            result = result + last;
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        String result = " ";

        String webtext = getWebContents("https://cis.temple.edu/~jfiore/2017/fall/1068/assignments/07/files/jaws.txt");

        int length = webtext.length();
        char ch;
        int a = 0;
        boolean boo = false;

        String Result = " ";
        String word = " ";

        // breaks the strings into characters 
        for (int x = 0; x <= length - 1; x++) {
            ch = webtext.charAt(x);
            //System.out.println(ch);

            if (ch == '"') {
                a += 1;
            }

            if (a % 2 == 0) {
                boo = false;
            } else {
                boo = true;
            }

            if (boo == false) {
                result += ch;
            }

            if (boo == true) {
                word += ch;
            }

            if (a == ' ') {
                result += (replacement(word));

                word = " ";
            }

        }

        System.out.print(result);
        saveDoc(result, "jaws.txt");

    }

}
