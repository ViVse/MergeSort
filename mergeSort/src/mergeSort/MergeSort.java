package mergeSort;

import java.util.Random;

public class MergeSort {
	
	static void merge(int arr[], int start, int middle, int end) {
		int l1 = middle - start + 1;
		int l2 = end - middle;
		
		int L[] = new int[l1];
		int R[] = new int[l2];
		
		for(int i = 0; i < l1; i++) 
			L[i] = arr[start + i];
		for(int i = 0; i < l2; i++)
			R[i] = arr[middle + 1 + i];
		
		int i = 0, j = 0, k = start;
		while(i < l1 && j < l2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < l1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(k < l2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int arr[], int start, int end) {
		if(start < end) {
			int middle = start + (end - start) / 2;
			
			sort(arr, start, middle);
			sort(arr, middle + 1, end);
			
			merge(arr, start, middle, end);
		}
	}
	
	static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int n = 10;
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = random.nextInt(0, 100);
		
		System.out.println("Array:");
		printArray(arr);
		
		sort(arr, 0, arr.length - 1);
		
		System.out.println("Sorted array:");
		printArray(arr);
	}

}
