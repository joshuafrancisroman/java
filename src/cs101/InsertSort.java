/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mike
 */
public class InsertSort {
    public static void main(String[] args) {
        try {
                Scanner file=new Scanner(new File("C:\\Users\\Mike\\Desktop\\file.txt"));
                String[] values=file.nextLine().split(" "); //values are in a 1 line file.
                int[]fixed = new int[values.length+1];
                for(int x=1;x<fixed.length;x++)
                    fixed[x]=Integer.parseInt(values[x-1]);
                sortInsert(fixed);
                for(int x=1;x<fixed.length;x++)
                    System.out.println(fixed[x]);                 
            } 
        catch (FileNotFoundException ex) 
            {
                Logger.getLogger(InsertSort.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void sortInsert(int[] arr)
    {
        int key;
        int y;
        for(int x=2; x<arr.length;x++)
        {
            key=arr[x];
            y=x-1;
            while(y>0 && arr[y]>key)// only runs if Left is greater than Right. Then will drop the key to bottommost
            {
                arr[y+1]=arr[y];
                y--; //go upto start to check if there is still lower number.
            }
            arr[y+1]=key;
        }
    }
}
