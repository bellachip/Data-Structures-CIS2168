/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;
import java.util.Scanner;

/**
 *
 * @author Belle
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Circle circle = new Circle("Circle");
        Square square = new Square("Square");
        Triangle triangle = new Triangle("Triangle");
        EquilateralTriangle equTri = new EquilateralTriangle("Equilateral Triangle");

        Scanner Input = new Scanner(System.in);
        
        //dimension for circle 
        System.out.println("Enter dimensions for Circle: ");
 
        circle.setDimensions(Input.nextDouble());
        circle.printDimensions();
        System.out.println(circle.getArea());

        //dimension for square  
        System.out.println("Enter dimensions for Square: ");
        square.setDimensions(Input.nextDouble(), Input.nextDouble());
        square.printDimensions();
        System.out.println(square.getArea());
        
         //dimension for triangle  
        System.out.println("Enter dimensions for Triangle: ");
        while (triangle.setDimensions(Input.nextDouble(), Input.nextDouble(), Input.nextDouble()) == -1) {
            System.out.println("Enter dimensions for Triangle:");
        }
       
        triangle.printDimensions();
        System.out.println(triangle.getArea());
        
        //print equilateral triangle 
        System.out.println("Enter dimensions for Equilateral Triangle: ");
        equTri.setDimensions(Input.nextDouble());
        equTri.printDimensions();
        System.out.println(equTri.getArea());

    }

}
