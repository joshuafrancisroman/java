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
public class CS101 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num;
        System.out.print("input number of loop:");
        num=input.nextInt();
        inputLoop test=new inputLoop(num);
    }
}
