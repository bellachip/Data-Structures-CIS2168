/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xkcd;

import java.util.Scanner;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Belle
 */
public class Xkcd {

    public static void main(String[] args) {

        String path = "https://xkcd.com/";
        int currentComic;
        Scanner reader;

        for (currentComic = 1; currentComic <= 100; currentComic++) {
            try {
                URL url = new URL(path + currentComic);
                reader = new Scanner(url.openStream());
                int start = -1;
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    if (line.contains("https://imgs.xkcd.com/comics/")) {

                        start = line.indexOf("https://imgs.xkcd.com/comics/");
                        URL imgURL = new URL(line.substring(start));
                        System.out.println(imgURL);

                        InputStream imgStream = imgURL.openStream();
                        Files.copy(imgStream, Paths.get(line.substring(line.lastIndexOf("/") + 1)));
                    }

                }
                reader.close();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
