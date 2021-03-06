package searchingAndSorting;

public class BubbleSort {

	static void bubbleSort(int arr[]) {
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) //[0, n-2] -> Indexes // Loop of passes
		{
			boolean didSwapHappen = false; //flag to check if swapping happens in this pass -> Made the program Efficient for some cases 
			for(int j=0;j<n-1-i;j++) //[0,n-i-2] -> Indexes //Loop of Swaps
			{
				if(arr[j] > arr[j+1])
				{
					didSwapHappen = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			if(!didSwapHappen) //(didSwapHappen == false) -> Swap didn't happen for this pass -> Array is sorted
			{
				break; //Outer loop break
				//we can use return also here
			}
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
		bubbleSort(arr);
		printArray(arr, true); // After Sorting

	}

}
