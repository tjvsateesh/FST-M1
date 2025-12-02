package activities;

import java.util.Arrays;

public class Activity4 {
	
	public static void main(String[] args) {
		
		int[] nums = {10, 23, 45, 68, 1, 93};
		System.out.println("Array before sorting: "+ Arrays.toString(nums));
		insertionSort(nums);
		System.out.println("Array after sorting: "+ Arrays.toString(nums));
			
	}
	
	public static void insertionSort(int[] nums) {
		int size = nums.length;
		
		for(int i = 1; i<size; i++) {
			int right = nums[i];
			int j = i - 1;
			
			while( j >= 0 && nums[j] > right) {
				nums[j+1] = nums[j];
				j = j - 1;
			}
			nums[j + 1] = right;
		}
		
	}

}
