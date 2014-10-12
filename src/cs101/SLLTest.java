/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;
import java.util.Scanner;

/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 6
* 
* 
*/
public class SLLTest {
    public static void main(String[] args) {
        int t;
        String s;
        Scanner input = new Scanner(System.in);     
        Scanner input2 = new Scanner(System.in);
        System.out.print("Insert variable T(1-4) : ");
        t=input.nextInt();                
        System.out.print("Insert string : ");
        s=input2.nextLine();       
        
        switch(t)
        {
            case 1:
                    String[] arr=s.split(" ");
                    System.out.println("Strings in the array:");
                    for(int x=0;x<arr.length;x++)
                        System.out.println(arr[x]);
                    
                    SLL<Integer> list = new SLL<>();
                    System.out.println("Linked List Contents:");
                    for(int w=0;w<arr.length;w++)
                    {
                        Integer temp = Integer.valueOf(arr[w]); //to access a static method(i.e valueOF)you use its class + the dot operator
                        list.insertDesc(temp);                        
                        System.out.println(list);
                    }
                    System.out.println("The Duplicates are:");
                    System.out.println(list.copyTheDups());
                    System.out.println("The Original list is:");
                    System.out.println(list);
                    break;
            case 2:
                
        }
        
        
    }
}

        //SLL <String> test = new SLL<>();
        /*test.addToHead("S");
        test.addToTail("H");
        test.insertAfterNode("Z", test.getNode("H"));
        
        test.delete("Z");
        test.insertDesc("L");
        test.insertDesc("Z");
        test.insertDesc("Y");
        test.insertDesc("A");
        for(int x=0; x<100;x++)
        {
            Integer k=(int)(Math.random()*100000);
            test.insertDesc(k.toString());
        }
        System.out.println(test);*/