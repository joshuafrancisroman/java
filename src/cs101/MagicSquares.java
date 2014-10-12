/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

import java.util.Scanner;

/*Roman,Joshua Francis
 * 3CSD
 * Lab Exercise 1
 * 
 */
public class MagicSquares 
{
    public static void main(String[] args) 
    {
        Scanner input= new Scanner(System.in);
        int n,t,k,x,y;//k is value to put into arr, x and y is coordinates.
        System.out.print("Input 'N'(Size of Matrix):");
        n=input.nextInt();
        int arr[][]=new int[n][n];
        System.out.print("Input 'T'(Starting value):");
        t=input.nextInt();
        if(t==1)
            buildMagicSquare(0,n/2,1,n,1,arr);
        else if(t==4)
            buildMagicSquare4(n-1,n/2,1,n,1,arr);
        for(x=0;x<n;x++)
        {
            for(y=0;y<n;y++)
                System.out.printf("%5d",arr[x][y]);
            System.out.println();
        }
        
    }
    static void buildMagicSquare(int x, int y, int k, int n, int t, int[][] arr)//x,y,k are important. n and t are just there for checking
    {
        if(k==n*n+1)
            return;
        if(x>=0 && y<n) //regular move
        {
            if(arr[x][y]==0)
                arr[x][y]=k;
            else //down move if valid
            {
                arr[x+2][y-1]=k;
                x+=2;
                y-=1;
            }
        }
        else if(x<0 && y<n) //warp move
        {
            arr[n-1][y]=k;
            x=n-1;
        }
        else if(x>=0 && y>=n) //warp move
        {
            arr[x][0]=k;
            y=0;
        }
        else //down move if invalid
        {
            arr[x+2][y-1]=k;
            x+=2;
            y-=1;
        }
        buildMagicSquare(x-1,y+1,k+1,n,t,arr);                               
    }
    
    
    static void buildMagicSquare4(int x, int y, int k, int n, int t, int[][] arr)//x,y,k are important. n and t are just there for checking
    {
        if(k==n*n+1)
            return;
        if(x<n && y>=0) //regular move
        {
            if(arr[x][y]==0)
                arr[x][y]=k;
            else //Up move if valid
            {
                arr[x-2][y+1]=k;
                x-=2;
                y+=1;
            }
        }
        else if(x<n && y<0) //warp move
        {
            arr[x][n-1]=k;
            y=n-1;
        }
        else if(x>=n && y<n && y>=0) //warp move
        {
            arr[0][y]=k;
            x=0;
        }
        else //Up move if invalid
        {
            arr[x-2][y+1]=k;
            x-=2;
            y+=1;
        }
        buildMagicSquare4(x+1,y-1,k+1,n,t,arr);                               
    }
}
