package activities;

public class Activity2 {
	
	public static void main(String[] args) {
		int[] nums = {10, 77, 10, 54, -11, 10};
		int result = 30;
		int searchFor = 10;
		boolean check = sumCheck(nums, searchFor, result);

		System.out.println("Is sum of "+searchFor+"s in the array is equal to "+result+" : "+check);
	}
	
	public static boolean sumCheck(int[] nums, int searchFor, int result) {
		int temp = 0;
		for(int num : nums) {
			if(num == 10) {
				temp = temp + num;
			}
		}
		
	return temp == result;
		
	}

}
