/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

/**
 *
 * @author Josh
 */
public class BST<T> extends BT<T>{
    
    public void insert(T key){
        if(root == null){//no node exists
            root = new BTNode<T>(key);
            root.level++;
            height++;
            return;
        }
        int ctr = 1; 
        BTNode<T> temp = root, pred = null;
        while( temp != null ){
            pred = temp;
            if(((Comparable)temp.info).compareTo(key)>0)//finding the insertion point
                temp = temp.left;
            else
                temp = temp.right;
            ctr++;
        }
        if(((Comparable)pred.info).compareTo(key)>0)
            pred = pred.left = new BTNode<T>(key);
        else
            pred = pred.right = new BTNode<T>(key);
        if( height < ctr)
            height = ctr;
        pred.level = ctr;
    }
    
    public BTNode<T> search(T key){
        BTNode<T> temp = root;
        while( temp != null){
            if(((Comparable)temp.info).compareTo(key)==0)
                return temp;
            else if(((Comparable)temp.info).compareTo(key)>0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return null;
    }
    
    public BTNode<T> findLCA(T key1, T key2){
        if( search(key1) == null || search(key2) == null )
            return null;
        BTNode<T> LCA = root;
        Queue<BTNode<T>> que = new Queue<>();
        que.enqueue(LCA);
        while(!que.isEmpty()){
            BST<T> tree = new BST<>();
            tree.setRoot(que.dequeue());
            if( tree.search(key2) != null && tree.search(key1)!=null){
                LCA = tree.root;
                if(LCA.left!=null)
                    que.enqueue(LCA.left);
                if(LCA.right!=null)
                    que.enqueue(LCA.right);
            }
        }    
        return LCA;
    }
    
}
