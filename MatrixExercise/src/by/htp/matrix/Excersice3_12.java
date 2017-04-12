package by.htp.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** I got the assignment : 06.04.2017 21.20 
* The assignment is complete : 09.04.2017 21.15
* @author - Kleinikov Stanislav
*/ 

public class Excersice3_12 {
	public static void main(String[] args){
		
		int[][] matrix = randomMatrix();
		printMatrix(matrix);
		MaximumNumberIncreaseValues(matrix);
		replaceMinValueTo(matrix);
		printMatrix(matrix);
		
	}

	/**
	 * To create a random matrix
	 */
	private static int[][] randomMatrix(){ 
		int dimensionMatrix;
		
		while(true){
			try{ 
				System.out.println("Enter the dimensions of the matrix");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				dimensionMatrix = Integer.parseInt(reader.readLine());
				if(dimensionMatrix>0){
				break;
				}
				else{
					throw new NegativeArraySizeException();
				}
			}
			catch(Exception e){
				System.out.println("Invalid number");
			}
		}
		
		int [][] matrix = new int[dimensionMatrix][dimensionMatrix];
		for(int i = 0;i < dimensionMatrix; i++){
			for(int j = 0; j < dimensionMatrix; j++){
				matrix[i][j] = -dimensionMatrix + (int)(Math.round((Math.random()*(2*dimensionMatrix))));
			}
		}
		return matrix;
	}
	
	/**
	 * Finds and displays the largest number of increasing elements of the matrix consecutively.
	 */
	private static void MaximumNumberIncreaseValues(int[][] matrix){
		int increaseCount = 0;
		int max = 0;
		
		for(int i = 0;i < matrix.length; i++){
			for(int j = 1; j < matrix.length; j++){
				if(matrix[i][j] > matrix[i][j-1]){
					increaseCount++;
				}
				else{
					if(max<increaseCount){
					max = increaseCount;
					increaseCount = 0;
					}
					else{
						increaseCount = 0;
					}
				}
			}
			if(max<increaseCount){
				max = increaseCount;
				increaseCount = 0;
			}
			else{
				increaseCount = 0;
			}
		}
			
		if(max == 0){
			System.out.println("Maximum number of increase values is: " + max);
		}
		else{
			System.out.println("Maximum number of increase values is: " + (max+1));
		}
	}
	
	/**
	 * Finds and displays the smallest values of matrix and and moves it to the specified line and column.
	 * 
	 */
	private static void replaceMinValueTo(int[][] matrix){
		int row = 0;
		int col = 0;
		int min = 0;
		
		for(int i = 0;i < matrix.length; i++){
			for( int j = 0; j < matrix.length; j++){
				if(min > matrix[i][j]){
					min = matrix[i][j];
					row = i;
					col = j;
				}
			}
		}
		System.out.println("Minimun value is: " + min);
		int targetRow = 0;
		int targetCol = 0;
		while(true){
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter target row");
				targetRow = Integer.parseInt(reader.readLine()); 
				System.out.println("Enter target col");
				targetCol = Integer.parseInt(reader.readLine());
				break;
			}
			catch(Exception e){
				System.out.println("Invalid number");
			}
		}
		swapRow(matrix,row,targetRow);
		swapCol(matrix,col,targetCol);
	}
	
	/**
	 * Replacement of two rows in the matrix
	 */
	private static void swapRow(int[][] matrix,int initialRow,int targetRow){
		
		 	int[] tmp = matrix[initialRow];
	        matrix[initialRow] = matrix[targetRow];
	        matrix[targetRow] = tmp;
		
	}
	
	/**
	 * Replacement of two columns in the matrix
	 */
	private static void swapCol(int[][] matrix,int initialCol,int targetCol){
		 for (int row = 0; row < matrix.length; row++){
	            int tmp = matrix[row][initialCol];
	            matrix[row][initialCol] = matrix[row][targetCol];
	            matrix[row][targetCol] = tmp;
	        }
	}
	
	/**
	 * Print the matrix
	 */
	static void printMatrix(int[][] matrix)
    {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}	
