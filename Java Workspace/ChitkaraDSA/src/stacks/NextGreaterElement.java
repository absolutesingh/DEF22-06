package stacks;

import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/
public class NextGreaterElement {
	// Function to find the next greater element for each element of the array.
	public static long[] nextLargerElement(long[] arr, int n) {
		long nextGreater[] = new long[n];
		for (int i = 0; i < n; i++) {
			nextGreater[i] = -1;
		}

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {
			while (!st.isEmpty() && (arr[i] > arr[st.peek()])) {
				int index = st.pop();
				nextGreater[index] = arr[i];
			}
			st.push(i);
		}

		return nextGreater;
	}
}