/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Write an algorithm that
•
fills an array indexed from 1 to 26 with the letters A to
Z,
•
shuffles or randomizes the array. You may call a rando
m number generator
function.
•
prints the shuffled contents of the array. 
 */
package cs101;

import java.util.Random;

/**
 *
 * @author Mike
 */
public class Problem1v2 {
    public static void main(String[] args) {
        char temp;
        int y;
        char[] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int x=0;x<26;x++)
        {
            Random rand=new Random();
            y=rand.nextInt(26);//uniformly (approx) distributed from [0,26);
            temp=alphabet[x];
            alphabet[x]=alphabet[y];
            alphabet[y]=temp;
        }
        for(int x=0;x<26;x++)
        {
            System.out.println(alphabet[x]);
        }
    }
}
