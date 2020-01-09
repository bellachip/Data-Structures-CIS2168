/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistpractice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Belle
 */
public class Arraylistpractice {

    private  int x;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List list = new ArrayList();
        
        list.add(1);
        list.add(5);
        list.add(8);
        
        System.out.println(list);
        System.out.println(list.get(0));
        //list.add (index:0, element:10000);
        System.out.println(list.get(0));
        System.out.println(list.set(0,999));
        System.out.println(list);
        
        for (int i=0; i< list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        
  
        
        // TODO code application logic here
    }

}
