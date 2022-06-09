package priorityQueuesAndHeaps;

//https://practice.geeksforgeeks.org/problems/heap-sort/1
class Solution {
	// Function to build a Heap from array.
	void buildHeap(int arr[], int n) {
		// start from parent of last node.
		// bcoz it will be the first node from end which isn't leaf

		int index = (n - 2) / 2; // ((Parent of node at index(n-1))
		for (int i = index; i >= 0; i--) {
			heapify(arr, i, n); // start from index i till n
		}
	}

	// Heapify function to maintain heap property.
	void heapify(int arr[], int start, int size) {
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

	void swap(int arr[], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	// Function to sort an array using Heap Sort.
	public void heapSort(int arr[], int n) {
		buildHeap(arr, n);

		for (int i = 0; i < n - 1; i++) {
			swap(arr, 0, n - 1 - i);// last index ko
			heapify(arr, 0, n - 1 - i); // n-1-i -> no. of elements now, as we would like not to see the last element
		}
	}
}