/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedlabthree;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Comparator;


/**
 *
 * @author Belle
 */
public class TimedLabThree {

    /* Remove all duplicate items from the given LinkedList     *
     *
     * Example input:
     * [1,4,6,3,1,3,4,5]
     * will be changed to
     * [1,4,6,3,5]
     * although
     * [3,5,6,4,1] or any permutation is also valid!
     *
     * You may create and use any additional data structures
     * (in fact I recommend it for the best score)
     *
     * Scoring based on runtime complexity
     * O(n) - 50 points
     * O(n^2) - 40 points
     * O(n^3) or worse - 30 points
     *
     * Remember to use the for each
     * No, you CANNOT use head or tail or nodes in this solution.
     */
    public static <E> void removeDuplicates(LinkedList<E> list) {

//           ListIterator iter = listIterator();
//
        HashSet tempSet = new HashSet();

        Iterator<E> iter = list.iterator();

        while (iter.hasNext()) {
            Object obj = iter.next();
            if (tempSet.contains(obj)) {
                iter.remove();
            } else {
                tempSet.add(obj);
            }
        }

    }

    /* Create a method that, given the root of a binary search tree,
     * finds the smallest item in the tree that is larger than the root.
     *
     * My solution wasn't recursive
     *
     * 25 points
     */
    public static <E> E smallestLarger(TreeNode root) {

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        E currentItem= (E) current.item;
        return  currentItem;
    }

    /* Write a method that determines if the given root of a tree or subtree
     * is a binary search tree
     *
     *
     * You will need to use .compareTo() on the items.
     *
     * 25 points
     */
    public static <E> boolean isBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        
        if (root.left.item.compareTo(root) > 0 || root.right.item.compareTo(root) < 0) {
            return false;
        } else {
            return isBST(root.left) && isBST(root.right);
        }
    }
/*
        if (max!= null && min.compareTo(root.item) > 0) {
            return false;
        }
        if (max != null && max.compareTo(root.item) <= 0) {
                return false;
            }
        

        return isBST(root.left, min, root.item)
                && isBST(root.right, root.item, max);
    }
*/
    
//    public <T> boolean isBST() {
//        return (isBST(root, T min,  T max));
//    }



// useful for writing your trees
private static class TreeNode<T extends Comparable<T>> {

    T item;
    TreeNode left;
    TreeNode right;
}



/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
