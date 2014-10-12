/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class textFile {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader text=new BufferedReader(new FileReader("C:\\Users\\Mike\\Desktop\\test.txt"));
        Scanner tets=new Scanner(new File("C:\\Users\\Mike\\Desktop\\test.txt"));
        String s=tets.nextLine();
        String[]k=s.split(" ");
        
    }
    
    
}

