/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4e2;

import java.util.Scanner;

/**
 *
 * @author work
 */
public class Lab4E2 {
    
     /** The method for multiplying two matrices */
    public static double[][] multiplyMatrix(double[][] m1, double[][] m2)
      {
          double[][] result = new double [m1.length][m1[0].length];//Creating a new 2D array to store the results
         
          
          for(int i = 0; i < result.length; i++)//Scan through the Result Row
             for(int j = 0; j < result[0].length; j++)//Scan through result column
             {
                for(int row = 0; row < m1.length; row++)//Increses the row variable
                    for(int col = 0; col < m1[0].length; col++)//Increases the col variable
                      {
                       result[i][j] += m1[col][j]*m2[i][row];//Formula to store the result   
                      }
             }
          
        return result;
      }    

    
    public static void main(String[] args) {
         Scanner keyboard = new Scanner(System.in);
         int n;
         double num;
         System.out.print("Enter the size of each matrix: ");
         n = keyboard.nextInt();
         System.out.println("Enter the matrix element");
         System.out.print("All elements of the matrices are assumed to be the same: ");
         num = keyboard.nextDouble();
         double[][] matrix1 = new double[n][n];
         for (int i = 0; i < n; i++) 
             for (int j = 0; j < n; j++)
                 matrix1[i][j] = num; 
         
        double[][] matrix2 = new double[n][n];
        
     for(int i = 0; i < n; i++)
         for (int j = 0; j < n; j++)
             matrix2[i][j] = num;
     
     long startTime, endTime, executionTime;
     startTime = System.currentTimeMillis();
     
     double[][] resultMatrix = multiplyMatrix(matrix1, matrix2); 
     
     endTime = System.currentTimeMillis();  executionTime = endTime - startTime;
     System.out.println("Execution time: " + executionTime + " millisecs"); 
        
       
    }
    
}
