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
public class square implements shape { 
    double sideLength;
    
    public square(double sideLength) {
        this.sideLength = sideLength;
    }


    
    public double getPerimeter() {
        return sideLength*4;
    }
    
    public double getArea() {
        return sideLength * sideLength;
    }
    
}
