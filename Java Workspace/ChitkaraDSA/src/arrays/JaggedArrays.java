package arrays;

public class JaggedArrays {

	public static void main(String[] args) {
		int oldArr[][] = new int[3][]; //No. of rows must be defined for jagged arrays
		oldArr[0] = new int[3];
		oldArr[1] = new int[2];
		oldArr[2] = new int[4];
		//0 0 0
		//0 0
		//0 0 0 0
		
		int arr[][] = new int[3][]; //No. of rows must be defined for jagged arrays
		//Array initializers list cannot be used to create Jagged arrays as it does not create a new object
//		arr[0] = {1,2,3}; //Cannot use array initializers list
		arr[0] = new int[] {1,2,3};
		arr[1] = new int[] {4,5};
		arr[2] = new int[] {6,7,8,9};
		//1 2 3
		//4 5
		//6 7 8 9
		
		for(int rows = 0; rows < arr.length; rows++)
		{
			for(int cols = 0; cols < arr[rows].length; cols++)
			{
				System.out.print(arr[rows][cols] + " ");
			}
			System.out.println();
		}
	}

}
