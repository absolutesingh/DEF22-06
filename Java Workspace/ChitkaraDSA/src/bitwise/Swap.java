package bitwise;
//https://practice.geeksforgeeks.org/problems/swap-two-numbers3844/1#
import java.util.*;

public class Swap {
	static List<Integer> get(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		List<Integer> result = new ArrayList<>();
		result.add(a);
		result.add(b);
		return result;
	}
}