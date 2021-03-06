package searchingAndSorting;

public class BinarySearch {

	static int binarySearch(int arr[], int x)
	{
		int l = 0;
		int r = arr.length - 1;
		
		while(l<=r)
		{
			int mid = (l+r)/2; //Index of middle element
			if(arr[mid] == x) return mid;
			if(x > arr[mid]) //Search in the right side
			{
				l = mid + 1;
			}
			if(x < arr[mid]) //Search in the left side
			{
				r = mid - 1;
			}
		}
		// l>r -> While loop breaks -> element not found
		return -1;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {2,5,8,12,16,23,38,56,72}; //Pre-requisite -> Sorted Array
		int x = 19;//The number to be searched
		int result = binarySearch(arr,x);
		if(result == -1)
		{
			System.out.println("Oops, element not found!");
		}
		else {
			System.out.println("Woohoo, Element found at index: " + result);
		}
	}

}
