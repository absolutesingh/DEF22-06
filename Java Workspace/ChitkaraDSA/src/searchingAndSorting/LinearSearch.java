package searchingAndSorting;

public class LinearSearch {

	static boolean searchInArray(int arr[], int x)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == x) return true; //Element found
		}
		return false; //return false
	}
	
	public static void main(String[] args) {
		int arr[] = {2,5,8,12,16,23,38,56,72};
		int x = 17;
		System.out.println(searchInArray(arr, x));
	}

}
