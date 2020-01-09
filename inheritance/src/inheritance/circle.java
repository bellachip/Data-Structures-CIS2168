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
public class circle implements shape {
    double radius; 
    
    public circle(double radius) {
        this.radius = radius;
    }
    
    public double getArea() {
       return Math.PI * radius * radius;
        
    }
    
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }
    
}
