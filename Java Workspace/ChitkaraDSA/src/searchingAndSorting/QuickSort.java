package searchingAndSorting;

public class QuickSort {

	static void quickSort(int arr[], int start, int end) {
		if (start >= end)
			return;
		int pIndex = partition(arr, start, end);
		quickSort(arr, start, pIndex - 1);
		quickSort(arr, pIndex + 1, end);
	}
	
	static int partition(int arr[], int start, int end)
	{
		int pivot = arr[end]; //Picking the last element as pivot
		int pIndex = start;
		for(int i=start;i<=end-1;i++) //to move all small elements in the front
		{
			if(arr[i]<pivot)
			{
				swap(arr, i, pIndex); //Swap elements at index i and pIndex
				pIndex++;
			}
		}
		swap(arr,pIndex,end); //swap for the last time
		return pIndex;
	}
	
	static void swap(int arr[], int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	static void merge(int arr[], int left[], int right[]) {
		int nL = left.length;
		int nR = right.length;

		int i = 0; // pointer to left array
		int j = 0; // pointer to right array
		int k = 0; // pointer to main(arr) array

		while (i < nL && j < nR) {
			if (left[i] <= right[j]) // element in left array is smaller
			{
				arr[k] = left[i];
				i++;
			} else // element in right array is smaller
			{
				arr[k] = right[j];
				j++;
			}
			k++; // yeh to krna hi hai, chahe left se uthao chaahe right se
		}

		while (i < nL) {
			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < nR) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	static void printArray(int arr[], boolean isSorted) {
		if (isSorted) {
			System.out.println("****Sorted Array****");
		} else {
			System.out.println("****Non-Sorted Array****");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 3, 7, 10, 11, 4, 1 };

		printArray(arr, false); // Before Sorting
		quickSort(arr, 0, arr.length - 1);
		printArray(arr, true); // After Sorting

	}

}