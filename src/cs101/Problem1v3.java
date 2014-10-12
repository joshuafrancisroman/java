/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

import java.util.Random;

/**
 *
 * @author Mike
 */
/*Given an array of 20 integers in random order, write an
algorithm that will sort the
integers in ascending order. */
public class Problem1v3 {
    public static void main(String[] args) {
        int[] arr=new int[26];
        Random rand=new Random();
        for(int x=0;x<26;x++)
        {
            arr[x]=rand.nextInt(32768);
        }
        recursiveSort(arr,0,arr.length-1);
        for(int x=0;x<26;x++)
            System.out.println(arr[x]);
    }
    
    static void recursiveSort(int[] arr,int x,int y)
    {
        if(x==arr.length-1)
            return;
        else if(x==y)
        {
            x+=1;
            y=arr.length;
        }           
        else if(arr[x]>arr[y])
        {
            int temp=arr[x];
            arr[x]=arr[y];
            arr[y]=temp;            
        }
        recursiveSort(arr,x,y-1);
    }
}
