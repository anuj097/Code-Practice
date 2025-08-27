package com.java.twoDArray.examples;

public class FindTheNumberofSquares {

	public static void main(String[] args) {
		int arr[][] = {
				{0, 1, 2, 3, 4, 5}, 
				{6, 7, 8, 9, 2, 1}, 
				{0, 1, 2, 3, 4, 5}, 
				{6, 7, 8, 9, 2, 1}, 
				{0, 1, 2, 3, 4, 5}, 
				{6, 7, 8, 9, 2, 1}};
		
		int m = arr.length;
        int n = arr[0].length;
        int size = 3;
        int count = 0;

        for (int i = 0; i <= m - size; i++) {
            for (int j = 0; j <= n - size; j++) {
                count++;
                System.out.println("3x3 Square #" + count + ":");
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        System.out.print(arr[i+r][j+c] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        System.out.println("Total 3x3 squares: " + count);

	}

}
