/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs101;
/*Roman,Joshua Francis
 * 3CSD
 * Lab Exercise 1
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*Roman,Joshua Francis
 * 3CSD
 * Lab Exercise 1
 */
public class FileSort {
    public static void main(String[] args) {
        try
        {
            Scanner input=new Scanner(System.in);
            char order, sort;
            int placehold=0;
            System.out.print("Input the number of values to be processed:");
            int n=input.nextInt();
            String [] k=new String[n+1]; //array starts in index 1.
            Scanner file=new Scanner(new File("ioc.txt"));
            for(int x=1;x<=n && file.hasNext();x++)
            {
                k[x]=file.nextLine();
                System.out.printf("%3d %s \n",x,k[x]);       
                placehold=x;
            }
            System.out.print("Choose sorting order(A,D,L):");
            input=new Scanner(System.in); //refresh buffer
            order=input.nextLine().charAt(0);
            System.out.print("Choose sorting algorithm(1):");            
            sort=input.nextLine().charAt(0);
            switch(sort)
            {
                case '1':quicksort(k,1,placehold,order);break;
            }
            System.out.println("The result is:");
            for(int x=1;x<=n && k[x]!=null;x++)
                System.out.printf("%3d %s \n",x,k[x]);
            
        }
        catch(IOException e)
        {
            e.printStackTrace(System.out);
        }
    }
    
    public static void quicksort(String[] values,int start,int end,char order)
    {
        int q=0;
        if(start<end)
        {
            switch(order)
                    {
                        case 'A':q=partition(values,start,end);break; //q is the partition index
                        case 'D':q=partitionD(values,start,end);break;
                        case 'L':q=partitionL(values,start,end);break;
                    }
            quicksort(values,start,q,order);
            quicksort(values,q+1,end,order);           
        }                
    }
    
    public static int partitionL(String [] values, int start,int end) //does not work, yet
    {
        String x=values[(int)(Math.random()*(end-start)+start)];//x=pivot //randomized pivot is the best!
        //String x=values[start];
        int i=start-1,j=end+1;//i and j are boundaries
        while(true)
        {
            
            do
                j--;
            while(values[j].length()>x.length()|| (values[j].compareTo(x)>0 && values[j].length()==x.length()));//check if <= tapos kung true check if equal and alphabetically less
            do
                i++;
            while(values[i].length()<x.length()|| (values[i].compareTo(x)<0 && values[i].length()==x.length()));
            if(i<j)
            {
                    String temp=values[i];
                    values[i]=values[j];
                    values[j]=temp;
            }
            else
                return j;
            
        }
    }
    
    public static int partition(String [] values, int start,int end) //does not work, yet
    {
        String x=values[(int)(Math.random()*(end-start)+start)];//x=pivot //randomized pivot is the best!
        //String x=values[start];
        int i=start-1,j=end+1;//i and j are boundaries
        while(true)
        {
            do
                j--;
            while(values[j].compareTo(x)>0);
            do
                i++;
            while(values[i].compareTo(x)<0);
            if(i<j)
            {
                    String temp=values[i];
                    values[i]=values[j];
                    values[j]=temp;
            }
            else
                return j;
            
        }
    }
    public static int partitionD(String [] values, int start,int end) //does not work, yet
    {
        String x=values[(int)(Math.random()*(end-start)+start)];//x=pivot
        int i=start-1,j=end+1;//i and j are boundaries
        while(true)
        {
            do
                j--;
            while(values[j].compareTo(x)<0);
            do
                i++;
            while(values[i].compareTo(x)>0);
            if(i<j)
            {
                    String temp=values[i];
                    values[i]=values[j];
                    values[j]=temp;
            }
            else
                return j;
            
        }
    }
  }  
    
    
   //this is alternative quicksort 
    
   /* public static int partition(String [] values, int start,int end)
    {
        String pivot=values[end];
        int pIndex=start;
        for(int x=start;x<end;x++)
        {
            if(pivot.compareTo(values[x])>=0)
            {
                String temp=values[pIndex];
                values[pIndex++]=values[x];
                values[x]=temp;
            }
        }
        String temp=values[pIndex];
        values[pIndex]=pivot;
        values[end]=temp;
        return pIndex;
        
    }
    
    public static int partitionD(String [] values,int start,int end)
    {
        String pivot=values[end];
        int pIndex=start;
        for(int x=start;x<end;x++)
        {
            if(pivot.compareTo(values[x])<=0)
            {
                String temp=values[pIndex];
                values[pIndex++]=values[x];
                values[x]=temp;
            }
        }
        String temp=values[pIndex];
        values[pIndex]=pivot;
        values[end]=temp;
        return pIndex;
    }
    
    */

