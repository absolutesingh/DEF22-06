package recursion;

import java.util.Scanner;

public class Fibonacci {
	
	static int fib(int n)
	{
		if(n==0) return 0;
		if(n==1) return 1;
		int a = fib(n-1);
		int b = fib(n-2);
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter a number n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fib(n));
	}
}
