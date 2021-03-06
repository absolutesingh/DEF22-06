package recursion;

public class LinearSearchUsingRecursion {

	static boolean searchInArrayUsingRecursion(int arr[], int x, int index)
	{
		if(index == arr.length) return false; //Base Condition -> Element not found in array
		if(arr[index] == x) return true; //Element found;
		return searchInArrayUsingRecursion(arr, x, index + 1);
	}
	
	public static void main(String[] args) {
		int arr[] = {2,5,8,12,16,23,38,56,72};
		int x = 16;
		System.out.println(searchInArrayUsingRecursion(arr, x, 0));
	}

}
