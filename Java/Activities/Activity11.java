package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer,String> colours = new HashMap<Integer, String>();
		colours.put(1, "Violet");
		colours.put(2, "Indigo");
		colours.put(3, "Blue");
		colours.put(4, "Green");
		colours.put(5, "Yellow");
		
		System.out.println("Elements in the Map: "+ colours);
		
		System.out.println("Removing 2nd element: "+ colours.remove(2));
		
		System.out.println("Is \"Green\" colour present in the map? "+ colours.containsValue("Green"));
		
		System.out.print("Current size of the map is: "+ colours.size());
		System.out.print(" "+ colours.values());
		

	}

}
