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
public class inputLoop{
                      public inputLoop(int repeat)
                      {
                          Scanner input=new Scanner(System.in);
                          String[] k=new String[repeat];
                          int ctr=0;
                          for(int a=repeat;a!=0;a--,ctr++)
                          {
                              System.out.print("Input a string");
                              k[ctr]=input.nextLine();
                              System.out.print("This is your String"+k[ctr]);
                          }
                      }
}
