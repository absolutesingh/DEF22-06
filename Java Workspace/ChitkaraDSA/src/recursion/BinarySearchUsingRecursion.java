package recursion;

public class BinarySearchUsingRecursion {
	
	static int binarySearchUsingRecursion(int arr[], int x, int l, int r)
	{
		if(l>r) return -1; //Element not found
		int mid = (l+r)/2;
		if(arr[mid] == x) return mid; //Return the index where element is found
		else if(x > arr[mid]) //Search in the right side
		{
			return binarySearchUsingRecursion(arr, x, mid + 1, r);
		}
		else //(x < arr[mid]) //Search in the left side 
		{
			return binarySearchUsingRecursion(arr, x, l, mid - 1);
		}
	}

	public static void main(String[] args) {
		int arr[] = {2,5,8,12,16,23,38,56,72}; //Pre-requisite -> Sorted Array
		int x = 72;//The number to be searched
		int result = binarySearchUsingRecursion(arr, x, 0, arr.length - 1);
		if(result == -1)
		{
			System.out.println("Oops, element not found!");
		}
		else {
			System.out.println("Woohoo, Element found at index: " + result);
		}
	}

}
