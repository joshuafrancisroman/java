/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;
/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 8
* 
* 
*/
import java.util.Scanner;


public class StackExpr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        Scanner input2 = new Scanner(System.in);
        int t;
        String s;
        System.out.print("Input Integer t(1-6):");
        t = input.nextInt();
        System.out.print("Input String:");
        s = input2.nextLine();
        
        if(t == 1)
        {
            System.out.println("Prefix:" + s);
            System.out.println("Infix:" + Stack.prefixToInfix(s));
        }
    } 
}
