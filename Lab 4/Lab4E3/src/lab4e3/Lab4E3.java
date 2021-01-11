/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4e3;

import java.util.Scanner;

/**
 *
 * @author work
 */
public class Lab4E3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//Creates scanner to get input
        
        int n;
        
        System.out.println("Enter the Value of n: ");
        n = input.nextInt();//Gets input from the user
        
        long startTime, endTime, executionTime; 
        startTime = System.currentTimeMillis(); 
        
        for(int i = 0; i <= (int)Math.pow(2,n) - 1; i++)//For loop that runs 2^n - 1 times
           {
             String sb = Integer.toBinaryString(i);//Writes out the Binary numbers up to 2^n - 1; 
           }
        
        endTime = System.currentTimeMillis(); 
        executionTime = endTime - startTime;
        
        System.out.println("Execution Time: " + executionTime + " milliseconds.");//Prints execution time
    }
    
}
