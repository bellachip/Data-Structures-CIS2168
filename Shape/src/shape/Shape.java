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
public class Shape {
    
    private String name; 
   
    public Shape(String name){
        this.name = name; 
    }
    
    public String getName(){
        return name; 
    }
    
    public double getArea(){
        return 0.0; 
        
    }
    
    public void printDimensions(){
        System.out.println("No Dimensions");
    }


}
