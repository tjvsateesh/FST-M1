package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Abhi");
		names.add("Bhaskar");
		names.add("John");
		names.add("Leon");
		names.add("Ziya");
		
		System.out.print("Names in the List are ");
		for(String name : names) {
			System.out.print(name + ", ");
		}
		System.out.println();
		
		System.out.println("3rd name in the list: "+ names.get(4));
		
		System.out.println("Is John present in the list: "+ names.contains("John"));
		
		System.out.println("Size of the list before removing a name: "+ names.size());
		
		System.out.println("Size of the list after removing "+ names.remove(3) +": "+ names.size());

	}

}
