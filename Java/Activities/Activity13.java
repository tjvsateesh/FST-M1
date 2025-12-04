package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		Random indexGen = new Random();
		
		System.out.println("Note: Passing non-integer value will end accepting inputs \nEnter integer values:");
		
		while(scan.hasNextInt()) {
		    list.add(scan.nextInt());
		}
		
		Integer nums[] = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("Random index value: " + index);
        System.out.println("Value at the given index: " + nums[index]);
 
        scan.close();

	}

}
