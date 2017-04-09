package by.htp.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** I got the assignment : 06.04.2017 21.20 
* The assignment is complete : 09.04.2017 21.15
* @author - Kleinikov Stanislav
*/ 

public class Excersice3 {
	public static void main(String[] args){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int m = 0;
		int increaseCount = 0;
		int max =0;
		
		while(true){
			try{ 
				System.out.println("Enter the dimensions of the matrix");
				m = Integer.parseInt(reader.readLine());
				break;
			}
			catch(Exception e){
				System.out.println("Invalid number");
			}
		}
		
		int [][] matrix = new int[m][m];
		for(int i = 0;i < m; i++){
			for(int j = 0; j < m; j++){
				matrix[i][j] = -m + (int)(Math.round((Math.random()*(2*m))));
			}
		}
		
		for(int i = 0;i < m; i++){
			for(int j = 0; j < m; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		for(int i = 0;i < m; i++){
			for(int j = 1; j < m; j++){
				if(matrix[i][j] > matrix[i][j-1]){
					increaseCount++;
				}
				else{
					max = increaseCount;
					increaseCount = 0;
				}
			}
		}
		if(max != 0)
			System.out.print(max+1);
		else
			System.out.print(max);
		
	}
}
