/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;
import java.lang.Math; 
/**
 *
 * @author Belle
 */
public class Square extends Shape {
     private double length, height;
     
    
    public Square(String name) {
        super(name);
    }
    
    public void setDimensions(double length, double height){
        this.length = length; 
        this.height = height; 
        
    }
    
    @Override
    public double getArea(){
        return length * height; 
    }
    
    
    @Override 
    public void printDimensions(){
        System.out.println("length: " + length + " height: " + height);
    }
    
     

    
}
