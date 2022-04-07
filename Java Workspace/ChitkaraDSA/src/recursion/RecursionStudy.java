package recursion;

import java.util.Scanner;

public class RecursionStudy {

	static void printDesc(int n)
	{
		if(n<1) return;
		System.out.print(n + " ");
		printDesc(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter a number n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printDesc(n);
	}

}
