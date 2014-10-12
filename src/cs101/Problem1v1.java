/*You are given a contiguous array A[1..n] filled from 1 to m,
m<n with data values sorted
in ascending order.
Write algorithms that will
•
insert a new data value into A, keeping A sorted and contiguo
us. You may need to
shift some data to higher indices.
•
delete a value in A, keeping A sorted and contiguous. You may
need to shift some
data to lower indices.
* */
package cs101;

import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Problem1v1 {
        public static void main(String[] args) {  
                Scanner input=new Scanner(System.in);
                int[] arr=new int[10];
                int n=7,temp2=0,ctr=0;
                for(ctr=0;ctr<=n;ctr++)
                    arr[ctr]=ctr+1;
                System.out.print("Input a number:");
                int temp=input.nextInt();
                //put the number into array then sort.
                ctr=0;
                arr[7]=0;
                arr[8]=0;
                arr[9]=0;
                while(temp!=0)
                {
                    for(ctr=0;temp>=arr[ctr] && arr[ctr]!=0;ctr++);
                    temp2=arr[ctr];
                    arr[ctr]=temp;
                    temp=temp2;
                }
                ctr=0;
                while(ctr<=9)
                    System.out.print(arr[ctr++]);
        }
}
