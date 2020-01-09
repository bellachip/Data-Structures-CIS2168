/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedlabthreeprac;

/**
 *
 * @author Belle
 */
public class TimedLabThreePrac <E> {
    
    private Node<E> head;
    private int size = 0;
    
    //contstructor 
    public TimedLabThreePrac(){
        head = null;
        size =0;
    }
    
    //adding to the end 
    public boolean add(E item){
        this.add(size, item);
        return true;
    }
    
    public E get (int index){ //O(1)
         if (index < 0 || index >= size){ //O(1)
            throw new IndexOutOfBoundsException("Not a valid index:("); 
        }
         return getNode(index).item;
        
    }
    
    public E set (int index, E item){ //O(1)
         if (index < 0 || index >= size){ //O(1)
            throw new IndexOutOfBoundsException("Not a valid index:("); 
        }
         Node<E> node = getNode(index);
         E toReturn= node.item;
         node.item = item; 
         return toReturn;
    }
    
    public void add (int index, E item){
        //Scenario 1. is this a valid index? index is out of bound
        if (index < 0 || index > size){ //O(1)
            throw new IndexOutOfBoundsException("Not a valid index:("); 
        }
        //Scenario 2: adding a new head
        Node<E> temp = new Node<E> (item);//create temp first and store the item in tmep
        if (index ==0 ){ //O(1) only creating one 
            temp.next =head; //storing memory location of head in temp.next this is creating link to head ** attatc first 
            head = temp; //store meory location of temp to head 
        }
        //Scenario 3: everything else since its antwhere else its not the head anymore
        else{ //O(n) because you have to get the node before 
            Node <E> before = getNode(index-1); //attatches the new node before to the node index-1
            temp.next = before.next;
            before.next = temp; 
            

        }
            
            size++;
        
    }
    
    public E remove (int index){
        E toReturn  = null;
        //Scenario 1. out of bounds 
        if (index <0 || index>= size){
            throw new IndexOutOfBoundsException("can not remove that.");
        } 
        //removing the head , just point to head.next
        if (index ==0) {
            toReturn = head.item;//first store the item 
            head = head.next;
        } 
        //remove everything else 
        else {
            Node<E> before = getNode(index-1);  //new node and point new node to the node before that its oging to get deleted 
            toReturn = before.next.item; // store the item to toreturn
            before.next = before.next.next;  
        }
        size--;
        return toReturn;
    }
    
    public int size(){ //O(1)
        return this.size();
    }
    
    //helper method
    private Node<E> getNode(int index){ // O(n)
        Node <E> current = head;
        
        for (int i = 0 ; i< index; i++){
            current = current.next;
        }
        return current;   
    }
    
    // [item0, item1, ... item n-1]
    public String toString(){
        String output= "[";
        Node <E> current = head; //where im currently at in the list 
        while (current!= null) {
            output += current.item.toString() + " ";
            current = current.next;
        }
        return output + "]";
     
    }
    

    //private cannot be accessed outside of this class
    private static class Node <E>{
        //the node holds the memory location of an item 
        E item; //E is a class time -- stores the memory location of the int or string 
        Node <E> next;//the  node doesnt actually store an item -- stores a memory location of another node-- java automatically translates memory location 
        
        //constructor
        //the tail has no memory location but contains null 
        //next contains the memory location of the next node. 
        
        public Node (E item){
            this.item = item;
        }
}
    
    // to add create a new node and simply attatch it give direction to find with was the origintal head 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         TimedLabThreePrac <String> l = new TimedLabThreePrac<>();
        l.add(0,"a");
        l.add(1, "b");
        l.add(2,"c");
        l.add(3, "d");
        l.add(4,"a");
        l.add(5, "b");
        
        System.out.println(l.remove(0));
        System.out.println(l);
        
        System.out.println(l);
    
    }
    
}
