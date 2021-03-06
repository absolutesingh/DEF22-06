package searchingAndSorting;

public class SelectionSort {

	static void selectionSort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) // [0 to n-2] in terms of index
		{
			//index of min element
			int minIndex = i;
			for(int j = i; j < n ; j++)
			{
				if(arr[j] < arr[minIndex])
				{
					minIndex = j; //agar chhota element j index pe hai to minIndex is j
				}
			}
//			We have found the minimum element -> minIndex
//			now we will swap the elements and bring the min element to the front
//			swap elements at index -> i and minIndex
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
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
		selectionSort(arr);
		printArray(arr, true); // After Sorting

	}

}
