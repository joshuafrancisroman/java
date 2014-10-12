/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

//Roman, Joshua Francis
//34 (Terminal Number)
//3CSD
//Lab Exercise 2 and Prelim Exam
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s;
        int t;
        boolean isPal = false;
        
        System.out.println("Input a number:");
        t=(int)input.nextFloat();       
        Scanner input2=new Scanner(System.in);
        System.out.println("Input a String:");
        s=input2.nextLine();
        String[] z=s.split(" ");
        switch(t)
        {
            case 1:isPal=isPalindrome(0,z.length-1,z);
                   if(isPal==true)
                        System.out.println("is a Palindrome");
                   else if(isPal==false)
                        System.out.println("is not a Palindrome");                
                    for(int x=0;x<z.length;x++)
                        {
                            System.out.println(z[x]);
                        }
                   break;
            case 2:System.out.println("The minimum is "+minR(0,z.length-1,z));break;
            case 3:break;
            case 4:boolean temp=isAscendingR(0,z.length-1,z);
                   if(temp)
                        System.out.println("is Ascending");
                   else    
                        System.out.println("is not Ascending");
                   break;
                
        }
    }
    
    static boolean isPalindrome(int x,int y,String[] z)
    {
        boolean isPal=false;
        if(x>=y)
            isPal=true;
        else if(z[x].compareTo(z[y])==0)       
            isPal=isPalindrome(x+1,y-1,z);
        else            
            isPal=false;      
        return isPal;
    }   

    static String minR(int x, int y, String[]z)
    {
        String min=z[x];
        if(x>=y);
        else
        {
            String temp=minR(x+1,y,z);
            if(min.compareTo(temp)>0)
                min=temp;
        }
        return min;
        
    }
    static boolean isAscendingR(int x,int y, String[]z)
    {
        boolean temp;
        if(x>=y)
            temp=true;
        else
        {
            temp=isAscendingR(x+1,y,z);
            if(temp && z[x].compareTo(z[x+1])<=0)
                temp=true;
            else
                temp=false;
        }
        return temp;
    }
}



