package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("Hello");
		hs.add("I");
		hs.add("am");
		hs.add("Chitti");
		hs.add("your");
		hs.add("assistant");
		
		String elementToBeRemoved = "new";
		
		System.out.println("Size of the hash set: "+ hs.size());
		
		System.out.println("Removing an element: "+ hs.remove("Hello"));
		
		if(hs.contains(elementToBeRemoved))
			hs.remove(elementToBeRemoved);
		else
			System.out.println("You are trying to remove an element \""+elementToBeRemoved+"\" which is not present");
		
		System.out.println("Is \"Chitti\" present in the Set? "+ hs.contains("Chitti"));
		
		System.out.println("Current Set "+ hs);
	}

}
