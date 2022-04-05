package arrays;

public class PassingArrays {

	static void addOne(int x, int arr[])
	{
		x = x + 1;
		System.out.println("Value of x in addOne() after increment is: " + x);
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = arr[i] + 1;
		}
		
		System.out.println("****Printing Array in addOne() Function");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		arr = null;
		System.out.println("Value of arr is: " + arr);
	}
	public static void main(String[] args) {
		int x = 10;
		int arr[] = new int[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = i+1; //1,2,3,4,5
		}
		
		System.out.println("****Printing Array in main before calling addOne() Function");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("Value of x in main before calling addOne() is: " + x);
		addOne(x, arr);
		System.out.println("Value of x in main after calling addOne() is: " + x);
		
		System.out.println("****Printing Array in main after calling addOne() Function");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
