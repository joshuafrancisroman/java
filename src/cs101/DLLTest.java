/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 7
* 
* 
*/
import java.util.Scanner;

public class DLLTest {
    public static void main(String[] args) {
        
        int t;
        String s;        
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.print("Input integer T(1-4):");
        t = input.nextInt();
        System.out.print("Input string S:");
        s = input2.nextLine();
        String[] arr = s.split(" ");
        
        if(t == 1)
        {
            System.out.println("Strings in the array:");
            for(int x = 0; x < arr.length; x++)
                System.out.println(arr[x]);
            
            DLL<Integer> list = new DLL<>();
            for(int x = 0; x < arr.length; x++)
                list.insertSorted(Integer.valueOf(arr[x]));
            System.out.println("The original sorted array: " + list.infoFwd());
            list.removeDups();
            System.out.println(list.infoFwd());
            System.out.println(list.infoBwd());
        }
    }
}
