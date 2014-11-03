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
public class BT<T>
{
    protected int height;
    protected BTNode<T> root;
    
    public BT()
    {
        root = null;
        height = 0;
    }
    
    public BT(BTNode<T> n)//n is a BT node
    {
        root = n;
        height = 1;
    }
    
    public void setRoot(BTNode<T> n)//same as above
    {
        root = n;
        height = 1;
    }
    
    public void computeLevels()//computes levels through traversal method
    {
        height = 0;//reinitialize the height because traversal will fix it
        breadthFirst();      
    }
    
    
    
    private void breadthFirst()
    {
        //breadthFirst traversal: enqueue root then, while queue is not empty, dequeue, print, then enqueue left and right
        BTNode<T> p = root;
        Queue<BTNode<T>> q = new Queue<>();
        Queue<Integer> lvl = new Queue<>();
        if(p != null)
        {
            Integer levelT = 1;//at least level 1  if root!=null
            q.enqueue(root);
            lvl.enqueue(levelT);
            while(!q.isEmpty())//will always run at least once
            {
                p = q.dequeue();
                levelT = lvl.dequeue();//levels are fluctuating so you need to enqueue and dequeue and overwrite
                p.level = levelT; //overwrites the level so it is already set.
                if(height<levelT)
                    height = levelT;
                System.out.println("K=" + p.getKey() +" level=" + p.level);
                if(p.left!=null)
                {
                    q.enqueue(p.left);
                    lvl.enqueue(levelT + 1);
                }
                if(p.right!=null)
                {
                    q.enqueue(p.right);
                    lvl.enqueue(levelT + 1);
                }
            }
        }
    }
    
    @Override
    public String toString()
    {
        if(root!=null)
            return "ht=" + height + " " + root.toString();//root.toString calls toString method of BTNode
        else
            return "ht=" + height;
    }
}
