package com.java.array.problems;

public class RotationOfArray {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		
		int arr1[] = {1,2,3,4,5,6};
		
		for(int i : rotateComplete(arr)) {
			System.out.print(i+ " ");
		}
		
		System.out.println();System.out.println();
		
		for(int i : rotateFirst2WithLast2(arr1)) {
			System.out.print(i+ " ");
		}
		
		System.out.println();System.out.println();
		
		int ar[] = {1,2,3,4,5};
		
		for(int i : slideLastTwoToFirst(ar, 2)) {
			System.out.print(i+ " ");
		}

	}
	
	public static int[] slideLastTwoToFirst(int arr[],int el) {
		
		int len = arr.length;
		int sl[] = new int[len];
		
		int j = 0;
		for(int i=len-el;i<arr.length;i++,j++) {
			sl[j] = arr[i];
		}
		
		for(int i=0;i<len-el;i++,j++) {
			sl[j] = arr[i];
		}
		
		
		
		return sl;
	}
	
	
	public static int[] rotateComplete(int arr[]) {
		
		int j=arr.length-1;
		for(int i=0;i<arr.length-1;i++,j--) {
			if(i>=j)
				break;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		
		// OR
		
		//  int i=0;
		//	int j=arr.length-1;
		//	while(i<j) {
		//  	int temp = arr[i];
		//		arr[i]=arr[j];
		//		arr[j]=temp;
		//		i++;
		//		j--;
		//	}
		
		
		
		return arr;
		
	}
	
	public static int[] rotateFirst2WithLast2(int arr[]) {
		
		int i=0;
		int j=arr.length-1;
		
		while(i<2) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return arr;
		
	}

}
