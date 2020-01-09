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
public class Triangle extends Shape {
    private  double a;
    private  double b;
    private  double c;
    private double s ;
    
    public Triangle(String name) {
        super(name);
    }
  
     public int setDimensions( double a, double b, double c){
        
        if (a + b > c && b + c > a && a + c > b) {
            System.out.println(a);
            this.a = a; 
            this.b = b; 
            this.c = c; 
            
        } else {
           return -1;
        }
      
         
        return 0; 
    }
     
    @Override 
    public double getArea(){
        this. s = (this.a + this.b + this.c)/2; 
        double area =(this.s * (this.s - this.a) * (this.s - this.b) * (this.s - this.c));
        return area;   
    }
    
    @Override
    public void printDimensions(){
        System.out.println("side a: " + this.a + " side b: " + this.b + " side c: " + this.c); 
    }
    
    
    
    
    
    
}
