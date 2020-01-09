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
public class EquilateralTriangle extends Triangle {
    private double a; 
    
    public EquilateralTriangle(String name) {
        super(name);
    }
    
    public void setDimensions(double a){
       super.setDimensions(a, a, a);
        
    }
    
    public void printDimensions(){
        System.out.println(" Side a: " + a);
    }
    
    
    
    
    
    
}
