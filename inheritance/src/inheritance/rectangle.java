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
public class rectangle implements shape {
    
    double length;
    double width;
    
    public rectangle (double length, double width) {
        this.length = length;
    }
    
    public double getPerimeter() {
        return length*2 +width*2;
    }
    
    @Override 
    public double getArea() {
        return 0;
        
    }
    
}
