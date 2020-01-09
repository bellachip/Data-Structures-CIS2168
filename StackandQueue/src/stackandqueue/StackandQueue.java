/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackandqueue;

/**
 *
 * @author Belle
 */
public class StackandQueue {
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            s.push(i);
        }
        
        while(!s.isEmpty()){
            System.out.println(s.pop());
        // TODO code application logic here
    }
    
}
}
