/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

import java.util.Scanner;

/**
 *
 * @author Mike
 */
//Print natural number from 0 to N. Ascending and Descending. Recursively. 
//Print natural ODD numbers from 1 to N. Descending and Ascending. Recursively.
public class Problem1v5and6and7 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("Input N:");
        int n=input.nextInt();
        Ascend(n);
        System.out.println();       
        System.out.println();
        AscendOdd(n);       
        System.out.println();       
        System.out.println();
        Descend(n);
        System.out.println();       
        System.out.println();
        DescendOdd(n);
    }
    
    static void Ascend(int n)
    {
        if(n==0)
            System.out.println(0);
        else
        {
            Ascend(n-1);
            System.out.println(n);
        }
    }
    
    static void Descend(int n)
    {
        if(n==0)
            System.out.println(0);
        else
        {   
            System.out.println(n);
            Descend(n-1);
        }
    }
    static void DescendOdd(int n)
    {
        if(n==1 || n==0)
        {
            System.out.println(1);
            return;
        }
        else if(n%2==1)
        {
            System.out.println(n);
        }      
        DescendOdd(n-1);
    }
    static void AscendOdd(int n)
    {
        if(n==1 || n==0)
        {
            System.out.println(1);
            return;
        }
        else if(n%2==1)
        { 
            AscendOdd(n-1);
            System.out.println(n);
        }
        else
            AscendOdd(n-1);
    }
}
