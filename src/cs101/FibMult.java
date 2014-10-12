/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

/* Roman, Joshua Francis
 * 3CSD-34
 * Lab Exercise 3
 * 
 */
import java.util.Scanner;


public class FibMult {
    public static void main(String[] args) {
        int n,t;
        long start,end;
        Scanner input= new Scanner(System.in);
        System.out.print("Input positive integer N: ");
        n=input.nextInt();       
        System.out.print("Input positive integer T: ");
        t=input.nextInt();
        start=System.nanoTime();
        switch(t)
                {
                    case 1:n=fibIterative(n);break;
                    case 2:n=fibRecursive(n);break;
                    case 3:n=multTable(n);break;
                }
        end=System.nanoTime();
        end-=start;
        System.out.println("The returned value is "+n+". It took "+end+" nanoseconds to execute.");   
    }
    
    public static int fibIterative(int n)
    {
        //worst bound O(n)
        int x,y,z;
        if(n==0)
            return 0;
        else
        {
            x=0; //f(0)
            y=1; //f(1)
            for(int i=2;i<=n;i++)
            {
                z=x+y;//z is the temp holding variable.
                x=y;
                y=z;
            }
        }
        return y;
    }
    
    public static int fibRecursive(int n)
    {
        if(n==1 || n==0)
            return n;
        else
            return fibRecursive(n-1)+fibRecursive(n-2);
    }
    
    public static int multTable(int n)
    {
        int i,j=1;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
                System.out.printf("%6d",i*j);   
            System.out.println();
        }
        return (i-1)*(j-1)/*or N*N */;
    }
}
