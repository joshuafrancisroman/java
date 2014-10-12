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
public class selectionR {
    public static void main(String[] args) {
        int arr[]={5,2,8,1,3,8,6,4};
        selectR(arr,0,arr.length-1);
        for(int x=0;x<arr.length;x++)
            System.out.println(arr[x]);
        
    }
    public static void selectR(int arr[],int start, int end)
    {
        if(start==end);//then already sorted
        else
        {
            
            int max=isMaxPos(arr,start,end); //find the max value in position
            int temp=arr[end]; //swap the max value position with to the end.
            arr[end]=arr[max];
            arr[max]=temp;            
            selectR(arr,start,end-1); //strip the end of 1 because the end is already the max
        }
    }
    public static int isMaxPos(int arr[],int start,int end)
    {
        int max=start;
        if(start==end);//already sorted
        else
        {
            int temp=isMaxPos(arr,start+1,end);
            if(arr[max]<arr[temp])
            {
                max=temp;
            }
        }
        return max;
    }
}
