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
public class BTTopDown {
    public static void main(String[] args) {
        BST<Character> bst1 = new BST<>();
        char search[]={'G','J','K','N','P','R','T'};
        char insert[]={'K','S','D','P','A','L','H','N','Q','M','J'};
        char lca[]={'A','Z','A','Q','Q','A','M','Q','S','N','L','L'};
        for(int x = 0; x < insert.length; x++)
            bst1.insert(insert[x]);
        System.out.println(bst1);
        
        for(int x = 0; x < search.length; x++){
            BTNode<Character> temp = bst1.search(search[x]);
            if(temp==null)
                System.out.println("Key not Found:" + search[x]);
            else
                System.out.println(temp + " " + "lvl=" + temp.level);
        }
        
        for(int x = 0; x < lca.length; x+=2){
            BTNode<Character> temp = bst1.findLCA(lca[x], lca[x+1]);
            if(temp==null)
                System.out.println( lca[x]+" "+lca[x+1]+" "+"No common ancestor");
            else
                System.out.println(temp + " " + "lvl=" + temp.level);
        }
            
    }
}
