/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistpractice;

/**
 *
 * @author Belle
 */
public class MyArrayList<E> {

    private int size; // how many items are in the list 
    private int capacity; // how many items the underlying array can hold 
    private E[] theData;

    //constructor- dont need what type
    public MyArrayList() {
        size = 0;
        capacity = 10;
        //theData = new E[10]; //dont know what e is 
        theData = (E[]) new Object[10];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;

    }
    
    public boolean add(E item) {
        return false;
    }
    //I want to add some item to specific intext in the arraylsit.
    public void add(int index, E item) {
        if (index < 0 || index>size) {
            throw new IndexOutOfBoundsException ("Index" + index + "was out of bounds");
            
        }if (size == capacity) {
             this.reallocate(); //more space
        }
        
        for (int i = size -1; i>= index; i--) {
            E temp = theData[i];
            theData[i+1] = temp;
        }
        
        theData[index] = item;
        size++;
    }
    
    public E remove(int index) {
        if (index<0 || index>= size) {
            throw new IndexOutOfBoundsException("we already went over this");
        }
        E item = theData[index] ;
        
        for (int i=index +1; i< size; i++) {
            E temp = theData[i];
            theData[i-1] = temp; //store to the location to the left 
            
        }
        size --;
        return item;
        
    }
    
    //no class can acess
    private void reallocate(){
        //doubles or 1.5x capacity 
        //dont do +1 capacity dont increase the capacity to 10 to 11 
        E[] newData = (E[]) new Object [2*capacity]; //cast 
        for (int i=0; i< theData.length; i++) {
            newData[i] = theData[i];
        }
        theData = newData;
        capacity = 2* capacity;
    }
    //tostring would print out a memory location
    public String toString(){
        String output = "[";
        for (int i=1; i<=size; i++) {
            output += ", "+theData[i];
        }
        for (E item: theData) {
            output += item + ", ";
        }
        
        return output + "]";
        
    }
    public static void main(String[] args) {
        MyArrayList <Integer> list = new MyArrayList<Integer>();
        for (int i=0; i<5; i++){
            list.add(i);
            System.out.println(list);
        }
        
        list.remove(1);
        System.out.println(list);
   
        
        
    }
}
