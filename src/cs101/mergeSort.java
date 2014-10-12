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
public class mergeSort {
    public static void main(String[] args) 
    {
        try {
                Scanner file=new Scanner(new File("C:\\Users\\Mike\\Desktop\\file.txt"));
                String[] values=file.nextLine().split(" "); //values are in a 1 line file.
                int[]fixed = new int[values.length+1];
                for(int x=1;x<fixed.length;x++)
                    fixed[x]=Integer.parseInt(values[x-1]);
                sortMerge(fixed,1,fixed.length-1);
                for(int x=1;x<fixed.length;x++)
                    System.out.println(fixed[x]);              
            } 
        catch (FileNotFoundException ex) 
            {
                Logger.getLogger(InsertSort.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void sortMerge(int[] values,int start,int end)
    {
        int mid;
        if(start<end)
        {
            mid=(start+end)/2;           
            sortMerge(values,start,mid);
            sortMerge(values,mid+1,end);    
            merge(values,start,end,mid);
        }
    }

    public static void merge(int[] val, int start, int end, int mid)
    {
        int[] val2 = new int[end+1];
        int nStart=start;
        int nMid=mid+1;
        int ctr=start;//important to make this a variable value and not a constant value
        nStart=start;
        for(;nStart<=mid && nMid<=end;ctr++)
        {
            if(val[nMid]>val[nStart])
                val2[ctr]=val[nStart++];
            else
                val2[ctr]=val[nMid++];
        }
        if(nMid>end)
            while(nStart<=mid)
                val2[ctr++]=val[nStart++];
        else
            while(nMid<=end)
                val2[ctr++]=val[nMid++];
        for(nStart=start;nStart<=end;nStart++) //val=val2 does not work.
            val[nStart]=val2[nStart];
    }
}
