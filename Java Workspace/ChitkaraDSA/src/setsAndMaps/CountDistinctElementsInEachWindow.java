package setsAndMaps;
//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1/
import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInEachWindow {

	ArrayList<Integer> countDistinct(int A[], int n, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < k; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}
		result.add(map.size()); // Added the no. of unique elements in window-1 to result

		for (int i = k; i < n; i++) {
			// Add the i'th element
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);

			// Remove the (i-k)th element
			if (map.get(A[i - k]) == 1) // if only one occurrence then remove from map
				map.remove(A[i - k]);
			else { // reduce the value by 1
				map.put(A[i - k], map.get(A[i - k]) - 1); // if more than one occurrence, reduce count by 1
			}

			result.add(map.size());
		}

		return result;
	}

}
