/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Belle
 */
public class ShapeExample {
    public static void main(String[] args) {
         shape s = new circle(5); // cannot do this because the method is not finished. 
         shape [] shapes = new shape[3];
         shapes[0] = new circle (4);
         shapes[1] = new square (3);
         shapes[2] = new rectangle (3,4);
         
         for (shape shapey : shapes) {
             System.out.println(shapey.getArea());
             System.out.println(shapey.getPerimeter());
         }
         
    }
    
}
