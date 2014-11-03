/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

/*ROMAN, JOSHUA FRANCIS
 *CS101  3CSD-34
 *LAB EXERCISE 11
 * Oct 23 2014
 */
public class BTBottomUp {//bottom up because you build the tree from the leaves. upward
    public static void main(String[] args) {
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> one = new BTNode<>(1,null,two);
        BTNode<Integer> five = new BTNode<>(5,four,null);
        BTNode<Integer> three = new BTNode<>(3,one,five);
        BT<Integer> bt = new BT<>();
        
        bt.computeLevels();
        System.out.println(bt);
        System.out.println();
        System.out.println();
        
        bt.setRoot(three);
        bt.computeLevels();//prerequisite to set the Levels and height.
        System.out.println(bt);
    }
}
