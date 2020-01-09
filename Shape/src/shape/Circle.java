/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author Belle
 */
public class Circle extends Shape {
    private final double pi = 3.14; 
    private double radius;

    public Circle(String name) {
        super(name);
    }
    
    
    public void setDimensions(double radius){
        this.radius = radius; 
         
        
    }
    
    @Override
    public double getArea(){
        return  2 * pi * radius;
    }
    
    //this will be used in the superclass
    @Override
    public void printDimensions(){
        System.out.println("radius: " + this.radius);
        
    }
    
}
