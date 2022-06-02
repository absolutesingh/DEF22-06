package setsAndMaps;

import java.util.HashMap;
import java.util.Map;

public class MapStudy {

	public static void main(String[] args) {
		// Big Basket -> Software to store fruit and quantity
//		(Mango,10)
		Map<String, Integer> map = new HashMap<>(); // Key-Value Pair
		map.put("Mango", 5);
		map.put("Apple", 7);
		map.put("Banana", 9);
		map.put("Orange", 9);
		System.out.println("Mangoes: " + map.get("Mango"));
		System.out.println("Orange: " + map.get("Orange"));
		map.put("Mango", 10); //Does not give an error but updates the value corresponding to the key
		System.out.println("Mangoes: " + map.get("Mango"));
		System.out.println("Kiwi: " + map.get("Kiwi"));
		System.out.println(map.containsKey("Kiwi"));
		System.out.println("Kiwi: " + map.getOrDefault("Kiwi", 0));
		System.out.println("Mangoes: " + map.getOrDefault("Mango", 0));
		
		System.out.println(map.keySet()); //This is a set, because the keys are unique
		System.out.println(map.values()); //This is not a set, it is a collection
		
		System.out.println(map.containsKey("Mango"));
		map.remove("Mango");
		System.out.println(map.containsKey("Mango"));
		
//		Ways to iterate HashMap -> Do watch these videos
//		https://www.youtube.com/watch?v=Yzlj88uyZWc&t=1384s
//		https://www.youtube.com/watch?v=GApVkMZza90&t=26s
	}

}
