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
public class BTNode<T> 
{
    protected T info;
    protected int level = 0; //relative value only working on the tree level. not set unless computeLevels had run
    protected BTNode<T> left, right;
    protected int degree = 0;
    
    public BTNode()
    {
        info = null;
        left = right = null;
    }
    
    public BTNode(T key)
    {
        info = key;
        left = right = null;
    }
    
    public BTNode(T key , BTNode<T> l, BTNode<T> r)
    {
        info = key;
        left = l;
        right = r;
    }
    
    public T getKey()
    {
        return info;
    }
    
    public int getDegree()
    {
        degree = 0; //reinitialize for multiple calling
        if(left!=null)
            degree+=1;
        if(right!=null)
            degree+=1;
        return degree;
    }
    
    @Override
    public String toString()//'this' is optional. just uses the caller BTnode
    {       
        if(info==null)
           return "";
        else
        {
            String s;
            s = "[K=" + info.toString();//calls toString method of object type T
            if(left!=null)//if caller node points to nothing at that side then that side is null
                s+= " L=" + left.toString();//recursive call left
            if(this.right!=null)
                s+= " R=" + right.toString();//recursive call right
            return s+"]";
        }
    }
}
