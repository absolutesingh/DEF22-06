package priorityQueuesAndHeaps;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
public class kLargestElements {
	static void buildHeap(int arr[], int n) {
		// start from parent of last node.
		// bcoz it will be the first node from end which isn't leaf

		int index = (n - 2) / 2; // ((Parent of node at index(n-1))
		for (int i = index; i >= 0; i--) {
			heapify(arr, i, n); // start from index i till n
		}
	}

	static void heapify(int arr[], int start, int size) {
		int index = start;

		while (2 * index + 1 < size) {
			int largerChildIndex = 2 * index + 1;

			if (2 * index + 2 < size && arr[2 * index + 2] > arr[2 * index + 1])// Right exists and is greater than left
			{
				largerChildIndex = 2 * index + 2;
			}

			if (arr[index] > arr[largerChildIndex]) {
				break;
			} else {
				swap(arr, index, largerChildIndex);
				index = largerChildIndex;
			}
		}
	}

	static void swap(int arr[], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	static int poll(int arr[], int size) {
		int elementToReturn = arr[0];

		swap(arr, 0, size - 1);
		size--; // removed one element

		heapify(arr, 0, size);

		return elementToReturn;
	}

	// Function to return k largest elements from an array.
	public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		buildHeap(arr, n);

		for (int i = 0; i < k; i++) {
			result.add(poll(arr, n - i));
		}

		return result;
	}
}