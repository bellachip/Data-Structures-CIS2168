/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackandqueue;

/**
 *
 * @author Belle
 */
public class Stack<E> {

    private Node<E> top;//only one instance variable, keep track of top only 

    public boolean isEmpty() {

        return top == null;
    }

    public E peek() {
        return top.item;
    }

    public E pop() {
        E toReturn = top.item;
        top = top.next;
        return toReturn;
    }

    public E push(E item) {
        Node<E> newTop = new Node <E>(item);
        newTop.next = top; //attatch the top
        top = newTop;
        return item;
    }

    private static class Node<E> {

        E item;
        Node <E> next;
        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            s.push(i);
        }
        
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }

}
