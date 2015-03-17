package mspkg;
import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		final int LENGTH = 100000;
		int[] a = new int[LENGTH];
		int[] aSel = new int[LENGTH];
		int[] aIns = new int[LENGTH];
		int[] aMer = new int[LENGTH];
		
		for (int i = 0; i < LENGTH; i++)
			a[i] = aSel[i] =  aIns[i] = aMer[i] = (int) (Math.random() * 1001);

		System.out.println("--- Unsorted ---");
		System.out.println();
		
		System.out.print("Selection Sort :");
		long start = System.currentTimeMillis();
		selectionSort(aSel);
		long end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		
		System.out.print("Insertion Sort :");
		start = System.currentTimeMillis();
		insertionSort(aIns);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		
		System.out.print("Merge Sort :");
		start = System.currentTimeMillis();
		mergeSort(aMer);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		System.out.println();
		
		System.out.println("--- Already Sorted ---");
		System.out.println();
		
		System.out.print("Selection Sort :");
		start = System.currentTimeMillis();
		selectionSort(aSel);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		
		System.out.print("Insertion Sort :");
		start = System.currentTimeMillis();
		insertionSort(aIns);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		
		System.out.print("Merge Sort :");
		start = System.currentTimeMillis();
		mergeSort(aMer);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		System.out.println();

		reverseArray(aSel);
		reverseArray(aIns);
		reverseArray(aMer);
		
		System.out.println("--- Reversed ---");
		System.out.println();
		
		System.out.print("Selection Sort :");
		start = System.currentTimeMillis();
		selectionSort(aSel);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		
		System.out.print("Insertion Sort :");
		start = System.currentTimeMillis();
		insertionSort(aIns);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		
		System.out.print("Merge Sort :");
		start = System.currentTimeMillis();
		mergeSort(aMer);
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
		System.out.println();

		System.out.println("--- First N Selection ---");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		start = System.currentTimeMillis();
		firstNSelection(a, scan.nextInt());
		end = System.currentTimeMillis();
		System.out.println((int) (end - start));
	}
	
	
	private static int[] merge(int[] a, int[] b, int[] temp) {
		int i = 0; int j = 0; int k = 0;
		 
		while (i != a.length && j != b.length) {
			if(a[i] > b[j]) {
		 		temp[k] = b[j];
		 		j++;
		 		k++;
		 	}
		 	else if (a[i] < b[j]) {
				temp[k] = a[i];
				i++;
				k++;		
			}
			else if (a[i] == b[j]) {
				temp[k] = b[j];
				j++; k++;
				temp[k] = a[i];
				k++; i++;
			}
		}
		
		if (i == a.length) {
			for(int p = j; j < b.length; j++) {
				temp[k] = b[j];
				k++;
			}
		}
		
		else if (j == b.length) {
			for(int q = i; i < a.length; i++) {
				temp[k] = a[i];
				k++;
			}
		}

		return temp;
	}
	
	public static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] front = new int [arr.length / 2];
			for(int i = 0; i < front.length; i++)
				front[i] = arr[i];
			mergeSort(front);
			
			int[] end = new int [arr.length - front.length];
			for(int i = arr.length / 2; i < end.length; i++)
				end[i - arr.length / 2] = arr[i];
			mergeSort(end);
			
			merge(front, end, arr);
		}
	}
	
	public static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			int idx = i;
			while (idx > 0 && temp < nums[idx - 1]) {
				nums[idx] = nums[idx - 1];
				idx--;
			}

			nums[idx] = temp;
		}
	}
	
	public static void selectionSort(int[] values) {
		for (int j = 0; j < values.length - 1; j++) {
			int minIndex = j;
			for (int k = j + 1; k < values.length; k++)
				if (values[k] < values[minIndex])
					minIndex = k;
			
			swap(values, j, minIndex);
		}
	}
	
	public static void firstNSelection(int[] values, int n) {
		for (int j = 0; j < n; j++) {
			int minIndex = j;
			for (int k = j + 1; k < values.length; k++)
				if (values[k] < values[minIndex])
					minIndex = k;
			
			swap(values, j, minIndex);
		}
	}
	
	private static void swap(int[] arr, int j, int k) {
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
	
	public static void reverseArray(int[] arr) {
		int[] temp = new int[arr.length];
		int k = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			temp[k] = arr[i];
			k++;
		}
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = temp[i];
	}
}