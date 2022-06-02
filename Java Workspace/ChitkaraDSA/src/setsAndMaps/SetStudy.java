package setsAndMaps;

import java.util.HashSet;
import java.util.Set;

public class SetStudy {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<>(); // Set is an interface, HashSet is class which has implemented the Set
											// interface
		System.out.println(s.size());
		System.out.println(s.isEmpty());
		s.add(1);// Insertion
		s.add(15);
		s.add(13);
		s.add(12);
		System.out.println(s.size());
		System.out.println(s.isEmpty());
		System.out.println(s.contains(12));// Searching
		System.out.println(s.contains(14));
		s.remove(12);// Deletion
		System.out.println(s.contains(12));
		System.out.println(s.size());
		s.add(15);// Does'nt give an error but does'nt add as well - duplicate elements are not
					// allowed
		System.out.println(s.size());

		System.out.println(s);
		// Printing elements in a set -> For Each/ Enhanced For Loop
		for (Integer x : s) // For Each Loop -> each element in set s come in variable x one by one
		{
			System.out.print(x + " ");
		}
		System.out.println();

		s.clear(); // Remove all elements from the set
		System.out.println(s.size());
		System.out.println(s.isEmpty());
	}

}
